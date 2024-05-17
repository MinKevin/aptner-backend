package com.aptner.v3.board.notice_post.controller;

import com.aptner.v3.board.common_post.controller.CommonPostController;
import com.aptner.v3.board.common_post.service.CommonPostService;
import com.aptner.v3.board.notice_post.domain.NoticePost;
import com.aptner.v3.board.notice_post.dto.NoticePostDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name="공지 사항")
@RequestMapping("/boards/notices")
public class NoticePostController extends CommonPostController<NoticePost, NoticePostDto.Request, NoticePostDto.Response> {
    public NoticePostController(CommonPostService<NoticePost, NoticePostDto.Request, NoticePostDto.Response> commonPostService) {
        super(commonPostService);
    }
}