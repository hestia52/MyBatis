package com.cssl.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author hestia
 * @since 2019-08-01
 */
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;

    private String sname;

    private LocalDateTime borndate;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public LocalDateTime getBorndate() {
        return borndate;
    }

    public void setBorndate(LocalDateTime borndate) {
        this.borndate = borndate;
    }

    @Override
    protected Serializable pkVal() {
        return this.sid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname=" + sname +
                ", borndate=" + borndate +
                "}";
    }
}
