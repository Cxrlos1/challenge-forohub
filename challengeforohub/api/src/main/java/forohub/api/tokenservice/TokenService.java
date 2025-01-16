package forohub.api.tokenservice;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String secret;

    @Value("${api.security.expiration}")
    private long expirationTime;

    public String generarToken(String username){
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                .sign(Algorithm.HMAC256(secret));
    }

    public String validarToken(String token){
        try {
            return JWT.require(Algorithm.HMAC256(secret))
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (Exception e){
            return null;
        }
    }
}
