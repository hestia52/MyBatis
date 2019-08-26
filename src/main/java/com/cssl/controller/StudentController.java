package com.cssl.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.service.StudentServiceImpl;
import com.cssl.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hestia
 * @since 2019-08-01
 */
@Controller
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    /**
     * 测试MyBatisPlus显示全部
     *
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Student> list = studentService.list();
        model.addAttribute("list", list);
        return "index";
    }

    /**
     * 测试MyBatisPlus带条件查询
     *
     * @param model
     * @return
     */
    @RequestMapping("/findByWhere")
    public String findByWhere(Model model) {
        List<Student> list = studentService.list(new QueryWrapper<Student>().lt("sid", 18).likeRight("sname", "read").orderByDesc("borndate"));
        model.addAttribute("list", list);
        for (Student s : list) {
            System.out.println("s:" + s);
        }
        return "index";
    }

    /**
     * 使用MyBatisPlus实现分页显示数据
     *
     * @param model
     * @return
     */
    @RequestMapping("/fenye")
    public String fenye(Model model) {
        IPage page = studentService.page(new Page(2, 10));
        long pages = page.getPages();//总页数
        long total = page.getTotal();//总记录数
        List list = page.getRecords();
        long current = page.getCurrent();//当前页
        long size = page.getSize();//每页显示记录数
        System.out.println("pages:" + pages);
        System.out.println("total:" + total);
        System.out.println("current:" + current);
        System.out.println("size:" + size);
        for (Object o : list) {
            System.out.println(o);
        }
        model.addAttribute("list", list);
        return "index";
    }

    /**
     * 查询根据id显示用户信息
     *
     * @param sid
     * @param model
     * @return
     */
    @RequestMapping("/findById")
    public String findById(Integer sid, Model model) {
        Student byId = studentService.getById(3);
        System.out.println("对象" + byId);
        model.addAttribute("list", byId);
        return "index";
    }

    /**
     * 测试新增
     *
     * @return
     */
    @RequestMapping("/add")
    public String addStudent() {
        Student student = new Student();
        student.setSname("sday");
        student.setBorndate(LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))));
        boolean save = studentService.save(student);
        System.out.println("save:" + save);
        return "succeed";
    }
}
