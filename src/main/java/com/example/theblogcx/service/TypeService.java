package com.example.theblogcx.service;

import com.example.theblogcx.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface TypeService {

    Type saveType(Type type);//保存数据

    Type getType(Long id);//获取数据

    Type getTypeByName(String name);//通过数据得到类别数据

    Page<Type> listType(Pageable pageable);//返回页数据

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    Type updateType(Long id,Type type);//修改数据

    void deleteType(Long id);//删除数据


}
