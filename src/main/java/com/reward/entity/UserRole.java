package com.reward.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(UserRoleId.class) // Composite Primary Key
public class UserRole {

    @Id
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_role_user"))
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_role_role"))
    private Role role;
}
