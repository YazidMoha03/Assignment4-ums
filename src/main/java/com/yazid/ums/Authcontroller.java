package com.yazid.ums;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller that handles authentication and JWT token generation
 * after successful GitHub OAuth login.
 */
@RestController
public class Authcontroller {

    // Secret key used to sign the JWT (in a real app, move to config/env)
    private final SecretKey jwtSecretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * This endpoint generates a JWT token after GitHub login.
     * It uses the GitHub username as the subject of the token.
     * The token expires in 15 minutes.
     */
    @GetMapping("/token")
    public Map<String, String> generateJwt(@AuthenticationPrincipal OAuth2User user) {
        // Extract username from GitHub user info
        String username = user.getAttribute("login");

        // Build the JWT
        String jwt = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 15 * 60 * 1000)) // 15 min expiry
                .signWith(jwtSecretKey)
                .compact();

        // Prepare response
        Map<String, String> response = new HashMap<>();
        response.put("username", username);
        response.put("jwt", jwt);
        return response;
    }

    /**
     * Simple root endpoint to show the app is running.
     */
    @GetMapping("/")
    public String home() {
        return "Hello, this is the home page!";
    }
}
