package leetcode.utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status extends Throwable {
    private String statusCode;
    private String message;
}
