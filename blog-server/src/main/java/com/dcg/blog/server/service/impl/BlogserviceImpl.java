package com.dcg.blog.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dcg.blog.server.dao.BlogDao;
import com.dcg.blog.server.service.Blogservice;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.fjl.common.entity.QueryPageBean;
import pers.fjl.common.po.Blog;
import pers.fjl.common.vo.BlogVO;

import javax.annotation.Resource;

@Service
public class BlogserviceImpl implements Blogservice {

    @Resource
    private BlogDao blogDao;

    /*添加或删除博客后，每页显示的博客都会发生变化，整个分页map都需要更新，所以得删除
     * @param queryPageBean: 
      * @return Page<BlogVO>
     * @author HNBTA
     * @description TODO
     * @date 2023/8/8 15:16
     */
    @Transactional
    //@Cacheable(value = {"BlogPage"}, key = "#root.methodName+'['+#queryPageBean.currentPage+']'+'['+#queryPageBean.pageSize+']'", condition = "#queryPageBean.queryString==null")
    @Override
    public Page<BlogVO> findHomePage(QueryPageBean queryPageBean) {
        //设置分页条件
        Page<BlogVO> page = new Page<>(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
        wrapper.like(queryPageBean.getQueryString() != null, "content", queryPageBean.getQueryString());
        page.setTotal(blogDao.selectCount(wrapper));
        page.setRecords(blogDao.findHomePage(queryPageBean));
        return page;
    }

}
