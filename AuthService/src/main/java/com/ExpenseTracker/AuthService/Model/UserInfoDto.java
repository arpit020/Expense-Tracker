package com.ExpenseTracker.AuthService.Model;


import com.ExpenseTracker.AuthService.Entity.UserInfo;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@JsonNaming (PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoDto extends UserInfo
{

    private String firstName; // first_name

    private String lastName; //last_name

    private Long phoneNumber;

    private String email; // email


    public String getUsername() {
        return super.getUsername(); // Calls the method from UserInfo
    }

    public String getPassword() {
        return super.getPassword(); // Calls the method from UserInfo
    }

    public void setPassword(String password){
        super.setPassword(password);
    }


}