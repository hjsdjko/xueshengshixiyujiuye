
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 工作管理人
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gongzuoguanliren")
public class GongzuoguanlirenController {
    private static final Logger logger = LoggerFactory.getLogger(GongzuoguanlirenController.class);

    @Autowired
    private GongzuoguanlirenService gongzuoguanlirenService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private GongsiService gongsiService;
    @Autowired
    private FudaojiaoshiService fudaojiaoshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("企业".equals(role))
            params.put("gongsiId",request.getSession().getAttribute("userId"));
        else if("工作管理人".equals(role))
            params.put("gongzuoguanlirenId",request.getSession().getAttribute("userId"));
        else if("辅导教师".equals(role))
            params.put("fudaojiaoshiId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = gongzuoguanlirenService.queryPage(params);

        //字典表数据转换
        List<GongzuoguanlirenView> list =(List<GongzuoguanlirenView>)page.getList();
        for(GongzuoguanlirenView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GongzuoguanlirenEntity gongzuoguanliren = gongzuoguanlirenService.selectById(id);
        if(gongzuoguanliren !=null){
            //entity转view
            GongzuoguanlirenView view = new GongzuoguanlirenView();
            BeanUtils.copyProperties( gongzuoguanliren , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody GongzuoguanlirenEntity gongzuoguanliren, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gongzuoguanliren:{}",this.getClass().getName(),gongzuoguanliren.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<GongzuoguanlirenEntity> queryWrapper = new EntityWrapper<GongzuoguanlirenEntity>()
            .eq("username", gongzuoguanliren.getUsername())
            .or()
            .eq("gongzuoguanliren_phone", gongzuoguanliren.getGongzuoguanlirenPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongzuoguanlirenEntity gongzuoguanlirenEntity = gongzuoguanlirenService.selectOne(queryWrapper);
        if(gongzuoguanlirenEntity==null){
            gongzuoguanliren.setCreateTime(new Date());
            gongzuoguanliren.setPassword("123456");
            gongzuoguanlirenService.insert(gongzuoguanliren);
            return R.ok();
        }else {
            return R.error(511,"账户或者工作管理人手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GongzuoguanlirenEntity gongzuoguanliren, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gongzuoguanliren:{}",this.getClass().getName(),gongzuoguanliren.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<GongzuoguanlirenEntity> queryWrapper = new EntityWrapper<GongzuoguanlirenEntity>()
            .notIn("id",gongzuoguanliren.getId())
            .andNew()
            .eq("username", gongzuoguanliren.getUsername())
            .or()
            .eq("gongzuoguanliren_phone", gongzuoguanliren.getGongzuoguanlirenPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongzuoguanlirenEntity gongzuoguanlirenEntity = gongzuoguanlirenService.selectOne(queryWrapper);
        if("".equals(gongzuoguanliren.getGongzuoguanlirenPhoto()) || "null".equals(gongzuoguanliren.getGongzuoguanlirenPhoto())){
                gongzuoguanliren.setGongzuoguanlirenPhoto(null);
        }
        if(gongzuoguanlirenEntity==null){
            gongzuoguanlirenService.updateById(gongzuoguanliren);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者工作管理人手机号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        gongzuoguanlirenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<GongzuoguanlirenEntity> gongzuoguanlirenList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            GongzuoguanlirenEntity gongzuoguanlirenEntity = new GongzuoguanlirenEntity();
//                            gongzuoguanlirenEntity.setUsername(data.get(0));                    //账户 要改的
//                            //gongzuoguanlirenEntity.setPassword("123456");//密码
//                            gongzuoguanlirenEntity.setGongzuoguanlirenName(data.get(0));                    //工作管理人姓名 要改的
//                            gongzuoguanlirenEntity.setGongzuoguanlirenPhoto("");//详情和图片
//                            gongzuoguanlirenEntity.setGongzuoguanlirenPhone(data.get(0));                    //工作管理人手机号 要改的
//                            gongzuoguanlirenEntity.setGongzuoguanlirenEmail(data.get(0));                    //邮箱 要改的
//                            gongzuoguanlirenEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            gongzuoguanlirenEntity.setCreateTime(date);//时间
                            gongzuoguanlirenList.add(gongzuoguanlirenEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //工作管理人手机号
                                if(seachFields.containsKey("gongzuoguanlirenPhone")){
                                    List<String> gongzuoguanlirenPhone = seachFields.get("gongzuoguanlirenPhone");
                                    gongzuoguanlirenPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> gongzuoguanlirenPhone = new ArrayList<>();
                                    gongzuoguanlirenPhone.add(data.get(0));//要改的
                                    seachFields.put("gongzuoguanlirenPhone",gongzuoguanlirenPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<GongzuoguanlirenEntity> gongzuoguanlirenEntities_username = gongzuoguanlirenService.selectList(new EntityWrapper<GongzuoguanlirenEntity>().in("username", seachFields.get("username")));
                        if(gongzuoguanlirenEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GongzuoguanlirenEntity s:gongzuoguanlirenEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //工作管理人手机号
                        List<GongzuoguanlirenEntity> gongzuoguanlirenEntities_gongzuoguanlirenPhone = gongzuoguanlirenService.selectList(new EntityWrapper<GongzuoguanlirenEntity>().in("gongzuoguanliren_phone", seachFields.get("gongzuoguanlirenPhone")));
                        if(gongzuoguanlirenEntities_gongzuoguanlirenPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GongzuoguanlirenEntity s:gongzuoguanlirenEntities_gongzuoguanlirenPhone){
                                repeatFields.add(s.getGongzuoguanlirenPhone());
                            }
                            return R.error(511,"数据库的该表中的 [工作管理人手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        gongzuoguanlirenService.insertBatch(gongzuoguanlirenList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        GongzuoguanlirenEntity gongzuoguanliren = gongzuoguanlirenService.selectOne(new EntityWrapper<GongzuoguanlirenEntity>().eq("username", username));
        if(gongzuoguanliren==null || !gongzuoguanliren.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(gongzuoguanliren.getId(),username, "gongzuoguanliren", "工作管理人");
        R r = R.ok();
        r.put("token", token);
        r.put("role","工作管理人");
        r.put("username",gongzuoguanliren.getGongzuoguanlirenName());
        r.put("tableName","gongzuoguanliren");
        r.put("userId",gongzuoguanliren.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody GongzuoguanlirenEntity gongzuoguanliren){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<GongzuoguanlirenEntity> queryWrapper = new EntityWrapper<GongzuoguanlirenEntity>()
            .eq("username", gongzuoguanliren.getUsername())
            .or()
            .eq("gongzuoguanliren_phone", gongzuoguanliren.getGongzuoguanlirenPhone())
            ;
        GongzuoguanlirenEntity gongzuoguanlirenEntity = gongzuoguanlirenService.selectOne(queryWrapper);
        if(gongzuoguanlirenEntity != null)
            return R.error("账户或者工作管理人手机号已经被使用");
        gongzuoguanliren.setCreateTime(new Date());
        gongzuoguanlirenService.insert(gongzuoguanliren);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        GongzuoguanlirenEntity gongzuoguanliren = new GongzuoguanlirenEntity();
        gongzuoguanliren.setPassword("123456");
        gongzuoguanliren.setId(id);
        gongzuoguanlirenService.updateById(gongzuoguanliren);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        GongzuoguanlirenEntity gongzuoguanliren = gongzuoguanlirenService.selectOne(new EntityWrapper<GongzuoguanlirenEntity>().eq("username", username));
        if(gongzuoguanliren!=null){
            gongzuoguanliren.setPassword("123456");
            boolean b = gongzuoguanlirenService.updateById(gongzuoguanliren);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrGongzuoguanliren(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        GongzuoguanlirenEntity gongzuoguanliren = gongzuoguanlirenService.selectById(id);
        if(gongzuoguanliren !=null){
            //entity转view
            GongzuoguanlirenView view = new GongzuoguanlirenView();
            BeanUtils.copyProperties( gongzuoguanliren , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = gongzuoguanlirenService.queryPage(params);

        //字典表数据转换
        List<GongzuoguanlirenView> list =(List<GongzuoguanlirenView>)page.getList();
        for(GongzuoguanlirenView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GongzuoguanlirenEntity gongzuoguanliren = gongzuoguanlirenService.selectById(id);
            if(gongzuoguanliren !=null){


                //entity转view
                GongzuoguanlirenView view = new GongzuoguanlirenView();
                BeanUtils.copyProperties( gongzuoguanliren , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody GongzuoguanlirenEntity gongzuoguanliren, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,gongzuoguanliren:{}",this.getClass().getName(),gongzuoguanliren.toString());
        Wrapper<GongzuoguanlirenEntity> queryWrapper = new EntityWrapper<GongzuoguanlirenEntity>()
            .eq("username", gongzuoguanliren.getUsername())
            .or()
            .eq("gongzuoguanliren_phone", gongzuoguanliren.getGongzuoguanlirenPhone())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongzuoguanlirenEntity gongzuoguanlirenEntity = gongzuoguanlirenService.selectOne(queryWrapper);
        if(gongzuoguanlirenEntity==null){
            gongzuoguanliren.setCreateTime(new Date());
        gongzuoguanliren.setPassword("123456");
        gongzuoguanlirenService.insert(gongzuoguanliren);
            return R.ok();
        }else {
            return R.error(511,"账户或者工作管理人手机号已经被使用");
        }
    }


}
