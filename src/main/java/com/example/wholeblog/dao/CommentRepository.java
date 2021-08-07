package com.example.wholeblog.dao;

import com.example.wholeblog.po.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);

    @Transactional
    @Modifying
    @Query("delete from t_comment c where c.parentComment.id = ?1")
    void deleteChildCommentByCommentId(Long commentId);

    @Transactional
    @Modifying
    @Query("delete from t_comment c where c.blog.id = ?1")
    void deleteAllByBlogId(Long blogId);

}
