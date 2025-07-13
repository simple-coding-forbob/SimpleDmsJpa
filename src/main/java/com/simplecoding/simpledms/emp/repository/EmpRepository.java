package com.simplecoding.simpledms.emp.repository;

import com.simplecoding.simpledms.emp.entity.Emp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Emp,Integer> {
    @Query(value = "select e from Emp e join fetch e.dept d\n" +
            "where e.ename like %:searchKeyword%")
    Page<Emp> selectAll(
            @Param("searchKeyword") String searchKeyword,
            Pageable pageable
    );
}
