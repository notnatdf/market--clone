package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Data;



@Getter
@Data
@AllArgsConstructor(staticName = "of")
public class AuthInfo {
    private Long memberId;


}
