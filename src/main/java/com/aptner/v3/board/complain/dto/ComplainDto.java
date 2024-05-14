package com.aptner.v3.board.complain.dto;

import com.aptner.v3.board.common_post.domain.CommonPost;
import com.aptner.v3.board.common_post.dto.CommonPostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ComplainDto {
    @Getter
    public static class Request extends CommonPostDto.Request {

    }

    @Getter
    @NoArgsConstructor
    public static class Response extends CommonPostDto.Response {

    }
}
