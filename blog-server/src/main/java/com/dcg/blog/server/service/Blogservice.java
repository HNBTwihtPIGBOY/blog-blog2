package com.dcg.blog.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import pers.fjl.common.entity.QueryPageBean;
import pers.fjl.common.vo.BlogVO;


public interface Blogservice {

    Page<BlogVO> findHomePage(QueryPageBean queryPageBean);

}
