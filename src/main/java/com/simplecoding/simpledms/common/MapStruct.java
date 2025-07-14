package com.simplecoding.simpledms.common;

import com.simplecoding.simpledms.dept.dto.DeptDto;
import com.simplecoding.simpledms.dept.entity.Dept;
import com.simplecoding.simpledms.emp.dto.EmpDto;
import com.simplecoding.simpledms.emp.entity.Emp;
import com.simplecoding.simpledms.faq.dto.FaqDto;
import com.simplecoding.simpledms.faq.entity.Faq;
import com.simplecoding.simpledms.filedb.dto.FileDbDto;
import com.simplecoding.simpledms.filedb.entity.FileDb;
import com.simplecoding.simpledms.gallery.dto.GalleryDto;
import com.simplecoding.simpledms.gallery.entity.Gallery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE  // null 제외 기능(update 시 사용)
)
public interface MapStruct {

    // TODO: 1) Dept <-> DeptDto
    DeptDto toDto(Dept dept);
    Dept toEntity(DeptDto deptDto);
    // TODO: 수정 시 사용: dirty checking 기능(save() 없이 수정 가능)
    void updateFromDto(DeptDto deptDto, @MappingTarget Dept dept);

    // TODO: 2) Emp <-> EmpDto
    @Mapping(source = "dept.dno", target = "dno")
    EmpDto toDto(Emp emp);
    @Mapping(source = "dno", target = "dept.dno")
    Emp toEntity(EmpDto empDto);
    // TODO: 수정 시 사용: dirty checking 기능(save() 없이 수정 가능)
//      경고 무시하고 싶으면 아래 추가하세요
    @Mapping(target = "dept", ignore = true)
    void updateFromDto(EmpDto empDto, @MappingTarget Emp emp);

    // TODO: 3) Dept <-> DeptDto
    FaqDto toDto(Faq faq);
    Faq toEntity(FaqDto faqDto);
    // TODO: 수정 시 사용: dirty checking 기능(save() 없이 수정 가능)
    void updateFromDto(FaqDto faqDto, @MappingTarget Faq faq);

    //    TODO: 4) fileDb <-> fileDto
    FileDbDto toDto(FileDb fileDb);
    FileDb toEntity(FileDbDto fileDbDto);

    //    TODO: 5) gallery <-> galleryDto
    GalleryDto toDto(Gallery gallery);
    Gallery toEntity(GalleryDto galleryDto);
}
