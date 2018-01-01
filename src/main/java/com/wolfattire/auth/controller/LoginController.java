package com.wolfattire.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolfattire.responseDto.ResponseDto;

@RestController
@RequestMapping("/user/login")
public class LoginController {

	@GetMapping("/authenticate")
    public ResponseEntity<ResponseDto> getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            authentication.getPrincipal();
        }
        return null;
    }
}
