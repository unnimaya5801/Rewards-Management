package com.reward.controller;

import com.reward.dto.UserDTO;
import com.reward.responsemodel.ResponseModel;
import com.reward.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 🔹 Get all users (optionally filtered by role)
     */
    @GetMapping
    public ResponseEntity<ResponseModel<List<UserDTO>>> getAllUsers(@RequestParam(required = false) String role) {
        return ResponseEntity.ok(userService.getAllUsers(role));
    }

    /**
     * 🔹 Get a user by ID
     */
    @GetMapping("/{userId}")
    public ResponseEntity<ResponseModel<UserDTO>> getUserById(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    /**
     * 🔹 Create a new user
     */
    @PostMapping
    public ResponseEntity<ResponseModel<String>> createUser(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    /**
     * 🔹 Soft delete a user
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<ResponseModel<String>> softDeleteUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.softDeleteUser(userId));
    }

    /**
     * 🔹 Update the logged-in user's profile
     */
    @PutMapping("/profile")
    public ResponseEntity<ResponseModel<String>> updateUserProfile(@RequestParam UUID userId, @Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUserProfile(userId, userDTO));
    }

    /**
     * 🔹 Get profile image
     */
    @GetMapping("/{userId}/image")
    public ResponseEntity<ResponseModel<byte[]>> getProfileImage(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.getUserProfileImage(userId));
    }

    /**
     * 🔹 Upload profile image
     */
    @PostMapping("/profile/image")
    public ResponseEntity<ResponseModel<String>> uploadProfileImage(@RequestParam UUID userId, @RequestParam MultipartFile file) throws IOException {
        return ResponseEntity.ok(userService.saveProfileImage(userId, file));
    }

    /**
     * 🔹 Update profile image
     */
    @PutMapping("/profile/image")
    public ResponseEntity<ResponseModel<String>> updateProfileImage(@RequestParam UUID userId, @RequestParam MultipartFile file) throws IOException {
        return ResponseEntity.ok(userService.updateProfileImage(userId, file));
    }

    /**
     * 🔹 Remove profile image
     */
    @DeleteMapping("/profile/image")
    public ResponseEntity<ResponseModel<String>> deleteProfileImage(@RequestParam UUID userId) {
        return ResponseEntity.ok(userService.deleteProfileImage(userId));
    }
}
