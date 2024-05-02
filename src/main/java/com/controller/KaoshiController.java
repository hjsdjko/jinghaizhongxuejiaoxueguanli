package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
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

import com.entity.KaoshiEntity;

import com.service.KaoshiService;
import com.entity.view.KaoshiView;
import com.service.JiaoshiService;
import com.entity.JiaoshiEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 考试信息
 * 后端接口
 * @author
 * @email
 * @date 2021-05-08
*/
@RestController
@Controller
@RequestMapping("/kaoshi")
public class KaoshiController {
    private static final Logger logger = LoggerFactory.getLogger(KaoshiController.class);

    @Autowired
    private KaoshiService kaoshiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private JiaoshiService jiaoshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
     
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }else if(StringUtil.isNotEmpty(role) && "教师".equals(role)){
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = kaoshiService.queryPage(params);

        //字典表数据转换
        List<KaoshiView> list =(List<KaoshiView>)page.getList();
        for(KaoshiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KaoshiEntity kaoshi = kaoshiService.selectById(id);
        if(kaoshi !=null){
            //entity转view
            KaoshiView view = new KaoshiView();
            BeanUtils.copyProperties( kaoshi , view );//把实体数据重构到view中

            //级联表
            JiaoshiEntity jiaoshi = jiaoshiService.selectById(kaoshi.getJiaoshiId());
            if(jiaoshi != null){
                BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setJiaoshiId(jiaoshi.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KaoshiEntity kaoshi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kaoshi:{}",this.getClass().getName(),kaoshi.toString());
        Wrapper<KaoshiEntity> queryWrapper = new EntityWrapper<KaoshiEntity>()
            .eq("kaoshi_name", kaoshi.getKaoshiName())
            .eq("xueke_types", kaoshi.getXuekeTypes())
            .eq("kaoshi_shijian", kaoshi.getKaoshiShijian())
            .eq("jiaoshi_id", kaoshi.getJiaoshiId())
            .eq("kaoshi_dizhi", kaoshi.getKaoshiDizhi())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaoshiEntity kaoshiEntity = kaoshiService.selectOne(queryWrapper);
        if(kaoshiEntity==null){
            kaoshi.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      kaoshi.set
        //  }
            kaoshiService.insert(kaoshi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KaoshiEntity kaoshi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kaoshi:{}",this.getClass().getName(),kaoshi.toString());
        //根据字段查询是否有相同数据
        Wrapper<KaoshiEntity> queryWrapper = new EntityWrapper<KaoshiEntity>()
            .notIn("id",kaoshi.getId())
            .andNew()
            .eq("kaoshi_name", kaoshi.getKaoshiName())
            .eq("xueke_types", kaoshi.getXuekeTypes())
            .eq("kaoshi_shijian", kaoshi.getKaoshiShijian())
            .eq("jiaoshi_id", kaoshi.getJiaoshiId())
            .eq("kaoshi_dizhi", kaoshi.getKaoshiDizhi())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaoshiEntity kaoshiEntity = kaoshiService.selectOne(queryWrapper);
        if(kaoshiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      kaoshi.set
            //  }
            kaoshiService.updateById(kaoshi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        kaoshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = kaoshiService.queryPage(params);

        //字典表数据转换
        List<KaoshiView> list =(List<KaoshiView>)page.getList();
        for(KaoshiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KaoshiEntity kaoshi = kaoshiService.selectById(id);
            if(kaoshi !=null){
                //entity转view
        KaoshiView view = new KaoshiView();
                BeanUtils.copyProperties( kaoshi , view );//把实体数据重构到view中

                //级联表
                    JiaoshiEntity jiaoshi = jiaoshiService.selectById(kaoshi.getJiaoshiId());
                if(jiaoshi != null){
                    BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaoshiId(jiaoshi.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody KaoshiEntity kaoshi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,kaoshi:{}",this.getClass().getName(),kaoshi.toString());
        Wrapper<KaoshiEntity> queryWrapper = new EntityWrapper<KaoshiEntity>()
            .eq("kaoshi_name", kaoshi.getKaoshiName())
            .eq("xueke_types", kaoshi.getXuekeTypes())
            .eq("kaoshi_shijian", kaoshi.getKaoshiShijian())
            .eq("jiaoshi_id", kaoshi.getJiaoshiId())
            .eq("kaoshi_dizhi", kaoshi.getKaoshiDizhi())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    KaoshiEntity kaoshiEntity = kaoshiService.selectOne(queryWrapper);
        if(kaoshiEntity==null){
            kaoshi.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      kaoshi.set
        //  }
        kaoshiService.insert(kaoshi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }





}

