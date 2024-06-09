package repository;

import java.util.Optional;

public interface MemberRespository {


    Optional<Object> findById(Long writerMemberId);
}
