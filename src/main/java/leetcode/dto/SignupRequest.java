package leetcode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
    private String username;
    private String email;
    private String password;

    // Getters and setters...
}
