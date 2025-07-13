package com.simplecoding.simpledms.dept.service;

import com.simplecoding.simpledms.common.ErrorMsg;
import com.simplecoding.simpledms.common.MapStruct;
import com.simplecoding.simpledms.dept.dto.DeptDto;
import com.simplecoding.simpledms.dept.entity.Dept;
import com.simplecoding.simpledms.dept.repository.DeptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeptService {

    //    DB CRUD 클래스 받기 : JPA 제공 함수 사용 가능
    private final DeptRepository deptRepository;
    private final MapStruct mapStruct;

    public Page<DeptDto> selectAll(String searchKeyword, Pageable pageable) {
        Page<Dept> page= deptRepository.selectAll(searchKeyword, pageable);
        return page.map(dept -> mapStruct.toDto(dept));
    }

    public DeptDto findById(int dno) {
//        JPA 상세조회 함수 실행
        Dept dept = deptRepository.findById(dno)
                .orElseThrow(() -> new RuntimeException(ErrorMsg.getMessage("errors.not.found")));

        return mapStruct.toDto(dept);
    }

    //    저장/수정 : 1) 기본키가(부서번호) 없으면 저장(insert)
//               2) 기본키가(부서번호) 있으면 수정(update)
//           => JPA 내부적으로 if문 있음 : 알아서 실행됨
    public void save(DeptDto deptDto) {
//        JPA 저장 함수 실행 : return 값 : 저장된 객체
        Dept dept=mapStruct.toEntity(deptDto);
        deptRepository.save(dept);
    }

    //    삭제 함수
    public void deleteById(int dno) {
        if (!deptRepository.existsById(dno)) {
            throw new RuntimeException(ErrorMsg.getMessage("errors.not.found"));
        }
        deptRepository.deleteById(dno);
    }
}

