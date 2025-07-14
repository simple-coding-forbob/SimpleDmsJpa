package com.simplecoding.simpledms.dept.service;

import com.simplecoding.simpledms.dept.dto.DeptDto;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Log4j2
@SpringBootTest
@EnableJpaAuditing
class DeptServiceTest {

    @Autowired
    DeptService deptService;

    @Test
    void selectDeptList() {
        String searchKeyword="";
        Pageable pageable = PageRequest.of(0,3);
        Page<DeptDto> page = deptService.selectDeptList(searchKeyword, pageable);
        log.info("테스트 : "+page.getContent());  // 패이지 안에 content 에 dept 객체가 있습니다.
    }

    @Test
    void save() {
//		1) 테스트 조건: Dept(dno,dname,loc)
        DeptDto deptDto=new DeptDto();
        deptDto.setDname("개발부2");
        deptDto.setLoc("서울");
//		2) 실제 메소드실행
        deptService.save(deptDto);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
    }

    @Test
    void findById() {
//		1) 테스트 조건: Dept(dno,dname,loc)
        long dno=30;
//		2) 실제 메소드실행
        DeptDto deptDto=deptService.findById(dno);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
        log.info(deptDto);
    }

    @Test
    void save2() {
//		1) 테스트 조건: Dept(dno,dname,loc)
        DeptDto deptDto=new DeptDto((long)20,"개발부","서울");
//		2) 실제 메소드실행
        deptService.save(deptDto);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
    }


    @Test
    void updateFromDto() {
//		1) 테스트 조건: Dept(dno,dname,loc)
        DeptDto deptDto=new DeptDto((long)30,"개발부2","서울");
//		2) 실제 메소드실행
        deptService.updateFromDto(deptDto);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
    }

    @Test
    void deleteById() throws Exception {
//		1) 테스트 조건: Dept(dno,dname,loc)
//		2) 실제 메소드실행
        deptService.deleteById((long)620);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
    }
}