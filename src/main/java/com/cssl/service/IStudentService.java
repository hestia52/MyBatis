package com.cssl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.Student;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hestia
 * @since 2019-08-01
 */
public interface IStudentService extends IService<Student> {
    IPage<Student> fenYe(Page page);
}
