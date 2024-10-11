<?php
header("Content-Type: application/json"); // Set the content type to JSON

include 'db.php'; // Include the database connection file

// Get the POST data from the request body
$data = json_decode(file_get_contents("php://input"));

// Validate input
if (!isset($data->username) || !isset($data->password)) {
    http_response_code(400); // Bad Request
    echo json_encode(["success" => false, "message" => "Username and password are required!"]);
    exit();
}

// Extract the username and password
$username = $data->username; // This will map to the 'user' field in your database
$password = $data->password;

// Prepare and bind the SQL statement to prevent SQL injection
$stmt = $conn->prepare("SELECT * FROM users WHERE user = ?");
$stmt->bind_param("s", $username);
$stmt->execute();
$result = $stmt->get_result();

// Check if the user exists
if ($result->num_rows > 0) {
    $user = $result->fetch_assoc(); // Fetch the user data
    // Verify the password using password_verify
    if (password_verify($password, $user['password'])) {
        http_response_code(200); // OK
        echo json_encode(["success" => true, "message" => "Login successful!"]); // Send success response
    } else {
        http_response_code(401); // Unauthorized
        echo json_encode(["success" => false, "message" => "Invalid password!"]); // Password mismatch
    }
} else {
    http_response_code(404); // Not Found
    echo json_encode(["success" => false, "message" => "User not found!"]); // User does not exist
}

// Close the statement and connection
$stmt->close();
$conn->close();
?>
