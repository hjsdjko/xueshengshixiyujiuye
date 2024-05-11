package com.dao;

import com.entity.GongzuoguanlirenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GongzuoguanlirenView;

/**
 * 工作管理人 Dao 接口
 *
 * @author 
 */
public interface GongzuoguanlirenDao extends BaseMapper<GongzuoguanlirenEntity> {

   List<GongzuoguanlirenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
