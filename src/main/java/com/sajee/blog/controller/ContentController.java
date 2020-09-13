package com.sajee.blog.controller;

import com.sajee.blog.model.Content;
import com.sajee.blog.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/saveContent", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Content> saveUserDetails(@RequestBody Content content) {
        content.setPublishedDate(new Date());
        return ResponseEntity.ok(contentService.save(content));
    }

    @RequestMapping(value = "/getContentByUserDetailsId", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Content>> getContentByUserDetailsId(@RequestParam int userDetailsId) {
        return ResponseEntity.ok(contentService.findByUserDetailsId(userDetailsId));
    }

    @RequestMapping(value = "/getContentByContentId", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Content> getContentByContentId(@RequestParam int contentId) {
        return ResponseEntity.ok(contentService.findContentByContentId(contentId));
    }

    @RequestMapping(value = "/getAllContents", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Content>> getAllContents() {
        return ResponseEntity.ok(contentService.findAll());
    }

    @RequestMapping(value = "/deleteContent", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteContent(@RequestParam int contentId) {
        contentService.deleteContent(contentId);
    }
}
