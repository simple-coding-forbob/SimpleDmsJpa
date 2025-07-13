package com.simplecoding.simpledms.filedb.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileDbDto {
    private String uuid;        // 기본키 : 자바생성
    private String fileTitle;   // 제목
    private String fileContent; // 내용
    private byte[] fileData;    // 업로드 이미지
    private String fileUrl;     // 파일 다운로드 url

    public FileDbDto(String fileTitle, String fileContent, byte[] fileData) {
        this.fileTitle = fileTitle;
        this.fileContent = fileContent;
        this.fileData = fileData;
    }
}
