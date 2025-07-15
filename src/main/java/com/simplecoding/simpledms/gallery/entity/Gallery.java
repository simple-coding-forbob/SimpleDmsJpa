package com.simplecoding.simpledms.gallery.entity;

import com.simplecoding.simpledms.common.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "TB_GALLERY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "uuid", callSuper = false)
public class Gallery extends BaseTimeEntity {
	@Id
	private String uuid;            // 기본키
	private String galleryTitle;    // 제목
	@Lob
	private byte[] galleryData;     // 이미지(blob)
	private String galleryFileUrl;  // 파일 다운로드 url
}

