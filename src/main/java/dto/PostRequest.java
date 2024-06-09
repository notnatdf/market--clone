package dto;

import lombok.Getter;
import lombok.Data;

@Data
@Getter
public class PostRequest {

    private String title;
    private String body;

}
