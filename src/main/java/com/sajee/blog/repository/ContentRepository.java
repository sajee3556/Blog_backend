package com.sajee.blog.repository;

import com.sajee.blog.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
    List<Content> findAll();
    List<Content> findByUserDetailsId(int userDetailsId);
    Content findContentByContentId(int contentId);
    void deleteContentByContentId(int contentId);
}
