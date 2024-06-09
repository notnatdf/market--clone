package service;

import dto.PostResponse;
import lombok.RequiredArgsConstructor;
import domain.Member;
import domain.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.MemberRespository;
import repository.PostRepository;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final MemberRespository memberRespository;
    public List<PostResponse> getAllPosts;

    public Post writePost(String title, String body, Long writerMemberId) {
        Member writer = memberRespository.findById(writerMemberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        return postRepository.save(
                        Post.builder()
                                .title(title)
                                .body(body)
                                .writer(writer)
                                .createdAt(LocalDateTime.now())
                                .build()
                );
    }

    public Collection<Object> getAllPosts() {
    }
}


