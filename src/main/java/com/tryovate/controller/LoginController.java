package com.tryovate.controller;

import com.tryovate.dto.ForgotPasswordDto;
import com.tryovate.dto.LoginDto;
import com.tryovate.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class LoginController {

    private User user = new User("shivb11", "Shiv@2000");

    @PostMapping("/login")
    public ResponseEntity<LoginDto> login(@RequestBody User loginUser) {

        if (user.getUsername().equals(user.getUsername()) &&
                user.getPassword().equals(loginUser.getPassword())) {
            return new ResponseEntity<>(new LoginDto("Login successful", true), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new LoginDto("Invalid username or password", false), HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<LoginDto> forgotPassword(@RequestBody ForgotPasswordDto forgotDto) {
        if (!user.getUsername().equals(forgotDto.getUsername())) {
            return new ResponseEntity<>(new LoginDto("Invalid username", false), HttpStatus.BAD_REQUEST);
        }

        if (!forgotDto.getNewPassword().equals(forgotDto.getConfirmPassword())) {
            return new ResponseEntity<>(new LoginDto("Passwords do not match", false), HttpStatus.BAD_REQUEST);
        }

        user.setPassword(forgotDto.getNewPassword());
        return new ResponseEntity<>(new LoginDto("Password updated successfully", true), HttpStatus.OK);
    }

   @GetMapping("/hi")
   public String demo() {
	   return "hi this is backend response";
   }

    /// creating  Session-based Authentication
//    @PostMapping("/login")
//    public ResponseEntity<LoginDto> login(@RequestBody User user, HttpSession session) {
//        if ("shivb11".equals(user.getUsername()) && "Shiv@2000".equals(user.getPassword())) {
//            session.setAttribute("username", user.getUsername()); // store username in session
//            LoginDto response = new LoginDto("Login successful", true);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } else {
//            LoginDto response = new LoginDto("Invalid username or password", false);
//            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
//        }
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<LoginDto> logout(HttpSession session) {
//        session.invalidate(); // destroys the session
//        LoginDto response = new LoginDto("Logout successful", true);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @GetMapping("/check-session")
//    public ResponseEntity<LoginDto> checkSession(HttpSession session) {
//        String username = (String) session.getAttribute("username");
//        if (username != null) {
//            return ResponseEntity.ok(new LoginDto("Session active for user: " + username, true));
//        } else {
//            return new ResponseEntity<>(new LoginDto("Session expired or not logged in", false), HttpStatus.UNAUTHORIZED);
//        }
//    }
}
