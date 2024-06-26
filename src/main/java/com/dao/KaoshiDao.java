package com.dao;

import com.entity.KaoshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KaoshiView;

/**
 * 考试信息 Dao 接口
 *
 * @author 
 * @since 2021-05-08
 */
public interface KaoshiDao extends BaseMapper<KaoshiEntity> {

   List<KaoshiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
