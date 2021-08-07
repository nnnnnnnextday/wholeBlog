package com.example.wholeblog.service;

import com.example.wholeblog.po.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);

    void deleteComment(Comment comment);
}
