package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.FudaojiaoshiLiuyanDao;
import com.entity.FudaojiaoshiLiuyanEntity;
import com.service.FudaojiaoshiLiuyanService;
import com.entity.view.FudaojiaoshiLiuyanView;

/**
 * 辅导教师留言 服务实现类
 */
@Service("fudaojiaoshiLiuyanService")
@Transactional
public class FudaojiaoshiLiuyanServiceImpl extends ServiceImpl<FudaojiaoshiLiuyanDao, FudaojiaoshiLiuyanEntity> implements FudaojiaoshiLiuyanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<FudaojiaoshiLiuyanView> page =new Query<FudaojiaoshiLiuyanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
