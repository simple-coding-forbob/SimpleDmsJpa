package com.simplecoding.simpledms.common;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * 에러 메세지를 가져와서 사용하는 클래스
 * 에러 메세지: messages.properties
 */
@Component
public class ErrorMsg {

    private static MessageSource messageSource;

    public ErrorMsg(MessageSource ms) {
        messageSource = ms;
    }

    // 파라미터 없이 메시지를 가져오는 전용 메서드
    public static String getMessage(String code) {
        return messageSource.getMessage(code, null, Locale.getDefault());
    }
}
