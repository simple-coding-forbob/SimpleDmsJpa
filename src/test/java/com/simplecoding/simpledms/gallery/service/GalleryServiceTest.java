package com.simplecoding.simpledms.gallery.service;

import com.simplecoding.simpledms.filedb.dto.FileDbDto;
import com.simplecoding.simpledms.filedb.service.FileDbService;
import com.simplecoding.simpledms.gallery.dto.GalleryDto;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest
@EnableJpaAuditing
class GalleryServiceTest {

    @Autowired
    GalleryService galleryService;

    @Test
    void selectGalleryList() {
        String searchKeyword="";
        Pageable pageable = PageRequest.of(0,3);
        Page<GalleryDto> page = galleryService.selectGalleryList(searchKeyword, pageable);
        log.info("테스트 : "+page.getContent());  // 패이지 안에 content 에 dept 객체가 있습니다.
    }
}