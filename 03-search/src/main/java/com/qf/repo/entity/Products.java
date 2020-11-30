package com.qf.repo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 
 * </p>
 *
 * @author zxp
 * @since 2020-11-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品编号
     */
    @TableId(value = "pid", type = IdType.AUTO)
    private Integer pid;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品分类ID
     */
    private Integer catalog;

    /**
     * 商品分类名称
     */
    private String catalogName;

    /**
     * 价格
     */
    private Double price;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 图片名称
     */
    private String picture;

    /**
     * 上架时间
     */
    private Date releaseTime;


}
