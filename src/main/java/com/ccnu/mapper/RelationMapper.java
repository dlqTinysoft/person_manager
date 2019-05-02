package com.ccnu.mapper;

import com.ccnu.dao.Relation;
import com.ccnu.dao.RelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelationMapper {
    int countByExample(RelationExample example);

    int deleteByExample(RelationExample example);

    int insert(Relation record);

    int insertSelective(Relation record);

    List<Relation> selectByExample(RelationExample example);

    int updateByExampleSelective(@Param("record") Relation record, @Param("example") RelationExample example);

    int updateByExample(@Param("record") Relation record, @Param("example") RelationExample example);
}