package com.simplecoding.simpledms.dept.entity;


import com.simplecoding.simpledms.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "TB_DEPT")
@SequenceGenerator(
        name = "SQ_DEPT_GENERATOR",
        sequenceName = "SQ_DEPT",
        allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DynamicInsert
@DynamicUpdate
public class Dept extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_DEPT_GENERATOR"
    )
    private Integer dno;   // 부서번호(기본키)
    private String  dname; // 부서명
    private String  loc;   // 부서위치
}

