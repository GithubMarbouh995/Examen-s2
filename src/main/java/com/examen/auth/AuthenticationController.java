package com.examen.auth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
//  @GetMapping("/confirm")
//  public ResponseEntity<String> confirm(@RequestParam String token) {
//    String responseMessage = service.confirmToken(token);
//    return ResponseEntity.ok(responseMessage);  ```
//  }
//  @PostMapping("/authenticate")
//  public ResponseEntity<AuthenticationResponse> authenticate(
//      @RequestBody AuthenticationRequest request
//  ) {
//    return ResponseEntity.ok(service.authenticate(request));
//  }
@PostMapping("/")
public ResponseEntity<?> authenticate(
        @RequestParam("email") String username,
        @RequestParam("password") String password,
        HttpServletResponse response
) {
  AuthenticationRequest request = new AuthenticationRequest(username, password);
  AuthenticationResponse authResponse = service.authenticate(request);

  if (authResponse != null) {
    String jwt = authResponse.getAccessToken();

    // Store JWT in a cookie (same as before)
    Cookie jwtCookie = new Cookie("jwt", jwt);
    jwtCookie.setHttpOnly(true);
    response.addCookie(jwtCookie);

    // Return JWT in the response body
    return ResponseEntity.status(HttpStatus.FOUND) // 302 Found
            .header(HttpHeaders.LOCATION, "/")
            .body(jwt);
  } else {
    // Authentication failed
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
  }
}


//  @PostMapping("/refresh-token")
//  public void refreshToken(
//      HttpServletRequest request,
//      HttpServletResponse response
//  ) throws IOException {
//    service.refreshToken(request, response);
//  }


}
