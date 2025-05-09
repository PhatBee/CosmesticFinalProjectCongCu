package  com.example.cosmesticappcongcu.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import  com.example.cosmesticappcongcu.model.Banner;
import  com.example.cosmesticappcongcu.model.Cart;
import  com.example.cosmesticappcongcu.model.CartItemRequest;
import  com.example.cosmesticappcongcu.model.Category;
import  com.example.cosmesticappcongcu.model.ForgotPasswordRequest;
import  com.example.cosmesticappcongcu.model.LoginRequest;
import  com.example.cosmesticappcongcu.model.LoginResponse;
import  com.example.cosmesticappcongcu.model.OtpVerificationRequest;
import  com.example.cosmesticappcongcu.model.PasswordResetResponse;
import  com.example.cosmesticappcongcu.model.Product;
import  com.example.cosmesticappcongcu.model.RegistrationRequest;
import  com.example.cosmesticappcongcu.model.RegistrationResponse;
import  com.example.cosmesticappcongcu.model.ResetPasswordRequest;
import  com.example.cosmesticappcongcu.model.User;
import  com.example.cosmesticappcongcu.model.UserUpdateDTO;
import  com.example.cosmesticappcongcu.model.UserUpdateResponse;

public interface ApiService {
    @GET("api/banners")
    Call<List<Banner>> getBanners();

    @POST("api/auth/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("api/auth/register")
    Call<RegistrationResponse> register(@Body RegistrationRequest request);

    @POST("api/auth/verify-otp")
    Call<RegistrationResponse> verifyOtp(@Body OtpVerificationRequest request);

    @POST("api/auth/resend-otp")
    Call<RegistrationResponse> resendOtp(@Query("email") String email);

    @POST("api/auth/forgot-password")
    Call<PasswordResetResponse> requestPasswordReset(@Body ForgotPasswordRequest request);

    @POST("api/auth/reset-password")
    Call<PasswordResetResponse> resetPassword(@Body ResetPasswordRequest request);

    @POST("api/auth/resend-password-reset-otp")
    Call<PasswordResetResponse> resendPasswordResetOtp(@Query("email") String email);

    @GET("api/categories")
    Call<List<Category>> getCategories();

    @GET("api/products/category/{categoryId}")
    Call<List<Product>> getProductsByCategory(@Path("categoryId") int categoryId);

    @GET("api/products/{productId}")
    Call<Product> getProductDetails(@Path("productId") Long productId);

    @GET("api/cart/user/{userId}")
    Call<Cart> getCart(@Path("userId") Long userId);

    @POST("api/cart/add")
    Call<Cart> addToCart(@Body CartItemRequest request);

    @PUT("api/cart/update")
    Call<Cart> updateCartItem(@Body CartItemRequest request);

    @DELETE("api/cart/remove/{userId}/{cartItemId}")
    Call<Cart> removeFromCart(@Path("userId") Long userId, @Path("cartItemId") Long cartItemId);

    @DELETE("api/cart/clear/{userId}")
    Call<Void> clearCart(@Path("userId") Long userId);

    @GET("/api/user/{userId}")
    Call<User> getUser(@Path("userId") Long userId);

    @PUT("/api/user/{userId}")
    Call<UserUpdateResponse> updateUser(@Path("userId") Long userId, @Body UserUpdateDTO userUpdateDTO);
}
