package controller;

import dto.AuthInfo;
import dto.PostRequest;
import dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PostService;
import domain.Post;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor

public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResponse> writePost(
            @RequestBody PostRequest postRequest,
            @RequestHeader("Authorization") String token
    ) {
        AuthInfo authInfo = authenticate(token);
        Post post = postService.writePost(postRequest.getTitle(), postRequest.getBody(), authInfo.getMemberId());
        return ResponseEntity.ok(PostResponse.from(post));
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        return ResponseEntity.ok(
                postService.getAllPosts().stream().map(PostResponse::from).collect(Collectors.toList())
        );

    }

    private AuthInfo authenticate(String token) {
        return new AuthInfo(member);
    }
}
