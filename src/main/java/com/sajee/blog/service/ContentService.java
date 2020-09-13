package com.sajee.blog.service;

import com.sajee.blog.model.Content;

import java.util.List;

public interface ContentService {
    Content save(Content content);

    List<Content> findByUserDetailsId(int userDetailsId);

    List<Content> findAll();

    Content findContentByContentId(int contentId);

    void deleteContent(int contentId);
}
