package com.reward.mapper;

import com.reward.dto.UserDTO;
import com.reward.entity.Role;
import com.reward.entity.User;
import java.util.Base64;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phoneNo(user.getPhoneNo())
                .roleId(user.getRole() != null ? user.getRole().getId() : null)
                .department(user.getDepartment())
                .year(user.getYear())
                .profileImage(user.getProfilePicture() != null 
                    ? Base64.getEncoder().encodeToString(user.getProfilePicture())  
                    : null)
                .build();
    }

    public User toEntity(UserDTO userDTO) {
        User user = User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .phoneNo(userDTO.getPhoneNo())
                .department(userDTO.getDepartment())
                .year(userDTO.getYear())
                .role(userDTO.getRoleId() != null ? new Role(userDTO.getRoleId(), null) : null) 
                .build();

        

        return user;
    }
}
