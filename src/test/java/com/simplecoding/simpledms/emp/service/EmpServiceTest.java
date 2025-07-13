package com.simplecoding.simpledms.emp.service;

import com.simplecoding.simpledms.emp.dto.EmpDto;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest
@EnableJpaAuditing
class EmpServiceTest {

    @Autowired
    private EmpService empService;

    //    Lazy Loading 사용시 트랜잭션 기능 필요함
    @Test
    void selectAll() {
        //		1) 테스트 조건:
        String searchKeyword="SCOTT";
        Pageable pageable = PageRequest.of(0,3);
//		2) 실제 메소드실행
        Page<EmpDto> page = empService.selectAll(searchKeyword, pageable);
        //		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
        log.info("테스트 : "+page.getContent());
    }

    @Test
    void save() {
//		1) 테스트 조건:
        LocalDate localDate=LocalDate.parse("2025-06-24"); // 컨트롤러에서는 자동 변환됨(단위테스트만 사용)
        EmpDto empDto=new EmpDto();
        empDto.setEname("홍길동");
        empDto.setJob("부장");
        empDto.setManager(8000);
        empDto.setHiredate(localDate);
        empDto.setSalary(5000);
        empDto.setCommission(1000);
        empDto.setDno(10);

//		2) 실제 메소드실행
        empService.save(empDto);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
    }


    @Test
    @Transactional
    void Save2() {
//		1) 테스트 조건:
        LocalDate localDate=LocalDate.parse("2025-06-24"); // 컨트롤러에서는 자동 변환됨(단위테스트만 사용)
        EmpDto empDto=new EmpDto();
        empDto.setEname("홍길동");
        empDto.setJob("부장");
        empDto.setManager(8000);
        empDto.setHiredate(localDate);
        empDto.setSalary(5000);
        empDto.setCommission(1000);
        empDto.setDno(10);

//		2) 실제 메소드실행
        empService.save(empDto);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
    }

    @Test
    void deleteById() throws Exception {
//		1) 테스트 조건:
//		2) 실제 메소드실행
        empService.deleteById(8001);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
    }
}