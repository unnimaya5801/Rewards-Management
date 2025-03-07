package com.reward.controller;

import com.reward.entity.Role;
import com.reward.responsemodel.ResponseModel;
import com.reward.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;


    @GetMapping
    public ResponseEntity<ResponseModel<List<Role>>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }


    @GetMapping("/{roleId}")
    public ResponseEntity<ResponseModel<Role>> getRoleById(@PathVariable UUID roleId) {
        return ResponseEntity.ok(roleService.getRoleById(roleId));
    }


    @GetMapping("/name/{roleName}")
    public ResponseEntity<ResponseModel<Role>> getRoleByName(@PathVariable String roleName) {
        return ResponseEntity.ok(roleService.getRoleByName(roleName));
    }


    @PostMapping
    public ResponseEntity<ResponseModel<Role>> createRole(@Valid @RequestBody Role role) {
        return ResponseEntity.ok(roleService.createRole(role));
    }


    @DeleteMapping("/{roleId}")
    public ResponseEntity<ResponseModel<String>> deleteRole(@PathVariable UUID roleId) {
        return ResponseEntity.ok(roleService.deleteRole(roleId));
    }
}
