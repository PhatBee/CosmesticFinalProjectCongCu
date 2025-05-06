package com.phatbee.cosmeticshopbackend.Service;


import com.phatbee.cosmeticshopbackend.Entity.User;
import com.phatbee.cosmeticshopbackend.dto.OtpVerificationRequest;
import com.phatbee.cosmeticshopbackend.dto.PasswordResetResponse;
import com.phatbee.cosmeticshopbackend.dto.ResetPasswordRequest;

import java.util.Date;

public interface UserService {
    boolean authenticate(String username, String password);
    String registerUser(String username, String email, String password, String fullName, Date birthday, String gender, String phone, String imageUrl);
    String activateAccount(String email, String otp);
    String resendOtp1(String email);
    String sendOtpForPasswordReset(String email);
    String resetPassword(String email, String otp, String newPassword);

    PasswordResetResponse requestPasswordReset(String email);
    PasswordResetResponse resetPassword(ResetPasswordRequest request);
    PasswordResetResponse resendOtpPasswordReset(String email);

    User getUserById(Long userId);

}
