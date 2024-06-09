package dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import domain.Post;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
@Data
public class PostResponse {

    private Long postId;
    private Long writerMemberId;
    private String title;
    private String body;
    private String writer;
    private LocalDateTime createdAt;

    public PostResponse() {

    }

    public static PostResponse from(Post post) {
        PostResponse response = new PostResponse();
                 response.setPostId(post.getId());
                 response.setWriterMemberId(response.getPostId());
                 response.setTitle(post.getTitle());
                 response.setBody(post.getBody());
                 response.setWriter(post.getWriter().getName());
                 response.setCreatedAt(post.getCreatedAt());
                 return response;
    }
}
