package com.aptner.v3.service;

import com.aptner.v3.article.Article;
import com.aptner.v3.article.ArticleComment;
import com.aptner.v3.article.ArticleCommentDTO;
import com.aptner.v3.repository.ArticleCommentRepository;
import com.aptner.v3.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    /* Article 전체 조회 */
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    /* Article 조회 */
    public Optional<Article> getArticleById(Long articleId) {
        log.debug("commentId, {}", articleId);
        return articleRepository.findById(articleId);
    }

    /* Article 생성 */
    public Article createArticle(Article articleDetails) {
        log.debug("article, {}", articleDetails);
        articleDetails.setCreatedDt(LocalDateTime.now());
        articleDetails.setCreatedBy("User");                // @todo
        return articleRepository.save(articleDetails);
    }

    /* Article 수정 */
    public Article updateArticle(Long id, Article articleDetails) {
        log.debug("article, {}", articleDetails);
        return articleRepository.findById(id)
                .map(article -> {
                    article.setTitle(articleDetails.getTitle());
                    article.setContent(articleDetails.getContent());
                    article.setHashtag(articleDetails.getHashtag());
                    article.setUpdatedDt(LocalDateTime.now());
                    article.setUpdatedBy("User");               // @todo
                    return articleRepository.save(article);
                })
                .orElse(null);
    }

    /* Article 삭제 */
    public void deleteArticle(Long articleId) {
        log.debug("articleId, {}", articleId);
        articleRepository.findById(articleId).ifPresent(articleRepository::delete);
    }

    public List<ArticleCommentDTO> getComments(Long articleId) {
        log.debug("articleId, {}", articleId);
        List<ArticleComment> comments  = articleCommentRepository.findByArticleId(articleId);
        return comments.stream()
                .map(comment -> {
                    ArticleCommentDTO dto = new ArticleCommentDTO();
                    dto.setId(comment.getId());
                    dto.setContent(comment.getContent());
                    dto.setUpdatedBy(comment.getUpdatedBy());
                    dto.setUpdatedDt(comment.getUpdatedDt());
                    dto.setCreatedBy(comment.getCreatedBy());
                    dto.setCreatedDt(comment.getCreatedDt());
                    return dto;
                })
                .collect(Collectors.toList());
    }
    /* Comment 생성 */
    public ArticleComment createComment(Long articleId, ArticleCommentDTO commentDetails) {
        log.debug("articleId, {}", articleId);
        log.debug("commentDetails, {}", commentDetails);
        return articleRepository.findById(articleId)
                .map(article -> {
                    ArticleComment comment = new ArticleComment();
                    comment.setContent(commentDetails.getContent());
                    comment.setArticle(article);
                    comment.setCreatedDt(LocalDateTime.now());
                    comment.setCreatedBy("User");                    // @todo
                    return articleCommentRepository.save(comment);
                })
                .orElse(null);
    }

    /* Comment 수정 */
    public ArticleComment updateComment(Long articleId, ArticleComment commentDetails) {
        log.debug("articleId, {}", articleId);
        log.debug("commentDetails, {}", commentDetails);
        return articleCommentRepository.findById(articleId)
                .map(comment -> {
                    comment.setContent(commentDetails.getContent());
                    comment.setUpdatedDt(LocalDateTime.now());
                    comment.setUpdatedBy("User");                     // @todo
                    return articleCommentRepository.save(comment);
                })
                .orElse(null);
    }

    /* Comment 삭제 */
    public void deleteComment(Long commentId)
    {
        log.debug("commentId, {}", commentId);
        articleCommentRepository.findById(commentId).ifPresent(articleCommentRepository::delete);
    }
}
