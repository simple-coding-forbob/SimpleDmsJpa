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

@Mapper(componentModel = "spring")
public interface MapStruct {
    // TODO: 1) Emp <-> EmpDto
    @Mapping(source = "dept.dno", target = "dno")
    EmpDto toDto(Emp emp);
    @Mapping(source = "dno", target = "dept.dno")
    Emp toEntity(EmpDto empDto);

    // TODO: 2) Dept <-> DeptDto
    DeptDto toDto(Dept dept);
    Dept toEntity(DeptDto deptDto);

    // TODO: 3) Dept <-> DeptDto
    FaqDto toDto(Faq faq);
    Faq toEntity(FaqDto faqDto);

    //    TODO: 4) fileDb <-> fileDto
    FileDbDto toDto(FileDb fileDb);
    FileDb toEntity(FileDbDto fileDbDto);

    //    TODO: 5) gallery <-> galleryDto
    GalleryDto toDto(Gallery gallery);
    Gallery toEntity(GalleryDto galleryDto);
}
