package com.simplecoding.simpledms.gallery.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GalleryDto {
    private String uuid;            // 기본키
    private String galleryTitle;   // 제목
    private byte[] galleryData;     // 이미지(blob)
    private String galleryFileUrl;  // 파일 다운로드 url

    public GalleryDto(String galleryTitle, byte[] galleryData) {
        this.galleryTitle = galleryTitle;
        this.galleryData = galleryData;
    }
}
