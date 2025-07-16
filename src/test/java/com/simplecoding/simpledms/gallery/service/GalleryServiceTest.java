package com.simplecoding.simpledms.gallery.service;

import com.simplecoding.simpledms.filedb.dto.FileDbDto;
import com.simplecoding.simpledms.filedb.entity.FileDb;
import com.simplecoding.simpledms.filedb.service.FileDbService;
import com.simplecoding.simpledms.gallery.dto.GalleryDto;
import com.simplecoding.simpledms.gallery.entity.Gallery;
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

    @Test
    void findById() throws Exception {
//		1) 테스트 조건(given):
        String uuid="12345672";
//		2) 실제 메소드실행(when)
        Gallery gallery=galleryService.findById(uuid);
//		3) 검증(확인)(then): 로그 , DB 확인, assert~ (DB확인)
        log.info(gallery);
    }

    @Test
    void deleteById() throws Exception  {
//		1) 테스트 조건: DeptVO(dno,dname,loc)
        String uuid="12345672";
//		2) 실제 메소드실행
        galleryService.deleteById(uuid);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
    }
}