package com.shopping.user.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.user.dto.UserDto;
import com.shopping.user.model.LoginRequestModel;
import com.shopping.user.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

//To check user authentication for login and on successful authentication generating JWT access token

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final UserService userService;
    private final String tokenExpiryTime;
    private final String tokenSecret;

    public AuthenticationFilter(UserService userService, String tokenExpiryTime, String tokenSecret, AuthenticationManager authenticationManager) {
        this.userService= userService;
        this.tokenExpiryTime= tokenExpiryTime;
        this.tokenSecret= tokenSecret;
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException
    {
        try
        {
            LoginRequestModel creds=new ObjectMapper().readValue(req.getInputStream(), LoginRequestModel.class);

            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(creds.getEmail(),creds.getPassword(),new ArrayList<>()));
        }
        catch(IOException e)
        {
            throw new RuntimeException();
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) {

        String userName= ((User)auth.getPrincipal()).getUsername();
        UserDto userDetails=userService.getUserDetailsByEmail(userName);

        String token= Jwts.builder()
                .setSubject(userDetails.getUserId())
                .setExpiration(new Date(System.currentTimeMillis()+Long.parseLong(tokenExpiryTime)))
                .signWith(SignatureAlgorithm.HS512,tokenSecret)
                .compact();

        res.addHeader("token", token);
        res.addHeader("userId", userDetails.getUserId());
    }

}

