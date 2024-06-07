package com.examen.auth;


import com.examen.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private Long id;

  private String name;
  private Date dob;
  private String email;
  private String password;
  private String image;
  private Role role;

}
