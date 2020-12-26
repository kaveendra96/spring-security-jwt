package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.model.AuthRQ;
import com.example.springsecurityjwt.model.AuthRS;
import com.example.springsecurityjwt.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthToken(@RequestBody AuthRQ authRQ) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRQ.getUsername(), authRQ.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password");
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRQ.getUsername());
        final String jwt = jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new AuthRS(jwt));
    }

}
