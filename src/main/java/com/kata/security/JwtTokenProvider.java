package com.kata.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

//    @Value("${app.jwtSecret}")
//    private String jwtSecret;
//
//    @Value("${app.jwtExpirationInMs}")
//    private int jwtExpirationInMs;
//
//    public String generarToken(String ip) {
//
//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
//
//        return Jwts.builder()
//                .setSubject(ip)
//                .setIssuedAt(new Date())
//                .setExpiration(expiryDate)
//                .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();
//    }
//
//    public String getTerminalFromJWT(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(jwtSecret)
//                .parseClaimsJws(token)
//                .getBody();
//
//        return claims.getSubject();
//    }
//
//    public void validarToken(String authToken) {
//        try {
//            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
//        } catch (MalformedJwtException ex) {
//            throw new TokenException("Token no válido", ex);
//        } catch (ExpiredJwtException ex) {
//        	throw new TokenException("Token expirado");
//        } catch (UnsupportedJwtException ex) {
//        	throw new TokenException("Token no soportado");
//        } catch (IllegalArgumentException ex) {
//        	throw new TokenException("JWT claims string is empty.");
//        }
//    }
}
