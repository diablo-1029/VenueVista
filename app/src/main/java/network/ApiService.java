package network; // Adjust this to your actual package structure

import models.SignupRequest;
import models.SignupResponse;
import models.User; // Import the User model
import models.MyResponse; // Import MyResponse model
import models.SearchResponse; // Import SearchResponse model
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    // Method for user signup
    @POST("signup.php") // Adjust the endpoint as necessary
    Call<SignupResponse> signup(@Body SignupRequest signupRequest);

    // Example GET request to fetch data from a specific endpoint
    @GET("your_endpoint")
    Call<MyResponse> getData();

    // Example GET request to fetch a user by their ID
    @GET("users/{id}")
    Call<User> getUserById(@Path("id") int userId);

    // Example GET request with a query parameter for searching
    @GET("search")
    Call<SearchResponse> searchItems(@Query("query") String searchTerm);
}
