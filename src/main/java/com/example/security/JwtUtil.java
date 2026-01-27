package com.example.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.dtos.RegisterResponseDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationMs}")
    private long jwtExpirationMs;

    // --------------------- SIGNING KEY ---------------------
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    // --------------------- GENERATE TOKEN ---------------------
    public String generateToken(RegisterResponseDTO res) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", res.getId());
        claims.put("name", res.getName());
        claims.put("phone", res.getPhone());
        claims.put("email", res.getEmail());
        claims.put("designation", res.getDesignation());
        claims.put("role", res.getRole());
        claims.put("createdAt", res.getCreatedAt().toString());
        claims.put("updatedAt", res.getUpdatedAt().toString());
        claims.put("isNotice", res.isNotice());
        claims.put("noticePeriod", res.getNoticePeriod());
        claims.put("dateOfJoining", res.getDateOfJoining().toString());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(res.getEmail()) // username
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // --------------------- VALIDATE TOKEN ---------------------
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // --------------------- EXTRACT CLAIMS ---------------------
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // --------------------- GETTERS (MATCH TOKEN CLAIMS) ---------------------

    public String getUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public Long getId(String token) {
        return extractAllClaims(token).get("id", Long.class);
    }

    public String getName(String token) {
        return extractAllClaims(token).get("name", String.class);
    }

    public String getPhone(String token) {
        return extractAllClaims(token).get("phone", String.class);
    }

    public String getEmail(String token) {
        return extractAllClaims(token).get("email", String.class);
    }

    public String getDesignation(String token) {
        return extractAllClaims(token).get("designation", String.class);
    }

    public String getRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    public String getDateOfJoining(String token) {
        return extractAllClaims(token).get("dateOfJoining", String.class);
    }
}
