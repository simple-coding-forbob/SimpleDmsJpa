package com.simplecoding.simpledms.faq.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "TB_FAQ")
@SequenceGenerator(
        name = "SQ_FAQ_GENERATOR",
        sequenceName = "SQ_FAQ",
        allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DynamicInsert
@DynamicUpdate
public class Faq {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_FAQ_GENERATOR"
    )
    private Long fno;           // 번호(기본키)
    private String title;      // 제목
    private String content;    // 내용
}
