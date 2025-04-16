package com.yazid.ums;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Authcontroller {

    // Generate a secret key (in a real app, use env variable or config)
    private final SecretKey jwtSecretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
   
    @RestController
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "Hello, this is the home page!";
    }
}

    @GetMapping("/token")
    public Map<String, String> generateJwt(@AuthenticationPrincipal OAuth2User user) {
        String username = user.getAttribute("login");

        String jwt = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 15 * 60 * 1000)) // 15 min expiry
                .signWith(jwtSecretKey)
                .compact();

        Map<String, String> response = new HashMap<>();
        response.put("username", username);
        response.put("jwt", jwt);
        return response;
    }
}
