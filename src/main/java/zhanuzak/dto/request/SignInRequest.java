package zhanuzak.dto.request;

import lombok.Builder;

@Builder
public record SignInRequest(String email,String password) {
}
