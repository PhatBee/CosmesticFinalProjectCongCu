package com.phatbee.cosmeticshopbackend.Controller;

import com.phatbee.cosmeticshopbackend.Service.Impl.UserServiceImpl;
import com.phatbee.cosmeticshopbackend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = userService.authenticate(loginRequest);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<RegistrationResponse> verifyOtp(@RequestBody OtpVerificationRequest request) {
        RegistrationResponse response = userService.verifyOtp(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/resend-otp")
    public ResponseEntity<RegistrationResponse> resendOtp(@RequestParam String email) {
        RegistrationResponse response = userService.resendOtpRegistration(email);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<PasswordResetResponse> requestPasswordReset(@RequestBody ForgotPasswordRequest request) {
        PasswordResetResponse response = userService.requestPasswordReset(request.getEmail());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<PasswordResetResponse> resetPassword(@RequestBody ResetPasswordRequest request) {
        PasswordResetResponse response = userService.resetPassword(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/resend-password-reset-otp")
    public ResponseEntity<PasswordResetResponse> resendOtpResetPassword(@RequestParam String email) {
        PasswordResetResponse response = userService.resendOtpPasswordReset(email);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request) {
        RegistrationResponse response = userService.register(request);
        return ResponseEntity.ok(response);
    }
}
