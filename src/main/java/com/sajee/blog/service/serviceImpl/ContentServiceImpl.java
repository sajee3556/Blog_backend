package com.sajee.blog.service.serviceImpl;

import com.sajee.blog.model.Content;
import com.sajee.blog.repository.ContentRepository;
import com.sajee.blog.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    public static final Logger logger = LoggerFactory.getLogger(ContentServiceImpl.class);

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    ProducerServiceImpl producerServiceImpl;

    @Override
    public Content save(Content content) {
        try {
             Content contentResponse = contentRepository.save(content);
             producerServiceImpl.sendMessage(contentResponse);
            return contentResponse;
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Content> findByUserDetailsId(int userDetailsId) {
        return contentRepository.findByUserDetailsId(userDetailsId);
    }

    @Override
    public List<Content> findAll() {
        return contentRepository.findAll();
    }

    @Override
    public Content findContentByContentId(int contentId) {
        return contentRepository.findContentByContentId(contentId);
    }

    @Override
    public void deleteContent(int contentId) {
        contentRepository.deleteById(contentId);
    }
}
