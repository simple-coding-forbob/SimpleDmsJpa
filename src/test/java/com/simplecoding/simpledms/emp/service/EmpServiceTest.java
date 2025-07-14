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

import java.time.LocalDate;

@Log4j2
@SpringBootTest
@EnableJpaAuditing
class EmpServiceTest {

    @Autowired
    private EmpService empService;

    //    Lazy Loading 사용시 트랜잭션 기능 필요함
    @Test
    void selectEmpList() {
        //		1) 테스트 조건:
        String searchKeyword="";
        Pageable pageable = PageRequest.of(0,3);
//		2) 실제 메소드실행
        Page<EmpDto> page = empService.selectEmpList(searchKeyword, pageable);
        //		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
        log.info("테스트 : "+page.getContent());
    }

    @Test
    void save() {
//		1) 테스트 조건:
        EmpDto empDto=new EmpDto();
        empDto.setEname("홍길동");
        empDto.setJob("부장");
        empDto.setManager((long)8000);
        empDto.setHiredate(LocalDate.now());
        empDto.setSalary((long)5000);
        empDto.setCommission((long)1000);
        empDto.setDno((long)30);

//		2) 실제 메소드실행
        empService.save(empDto);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
    }


    @Test
    void Save2() {
//		1) 테스트 조건:
        EmpDto empDto=new EmpDto();
        empDto.setEno((long)8047);
        empDto.setEname("홍길동2");
        empDto.setJob("부장");
        empDto.setManager((long)8000);
        empDto.setHiredate(LocalDate.now());
        empDto.setSalary((long)5000);
        empDto.setCommission((long)1000);
        empDto.setDno((long)20);

//		2) 실제 메소드실행
        empService.save(empDto);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
    }

    @Test
    void updateFromDto() {
//		1) 테스트 조건:
        EmpDto empDto=new EmpDto();
        empDto.setEno((long)8061);
        empDto.setEname("홍길동2");
        empDto.setJob("부장");
        empDto.setManager((long)8000);
        empDto.setHiredate(LocalDate.now());
        empDto.setSalary((long)5000);
        empDto.setCommission((long)1000);
        empDto.setDno((long)20);

//		2) 실제 메소드실행
        empService.updateFromDto(empDto);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
    }

    @Test
    void deleteById() throws Exception {
//		1) 테스트 조건:
//		2) 실제 메소드실행
        empService.deleteById((long)8061);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
    }
}