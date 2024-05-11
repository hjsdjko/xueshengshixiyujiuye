package com.dao;

import com.entity.FudaojiaoshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FudaojiaoshiView;

/**
 * 辅导教师 Dao 接口
 *
 * @author 
 */
public interface FudaojiaoshiDao extends BaseMapper<FudaojiaoshiEntity> {

   List<FudaojiaoshiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
