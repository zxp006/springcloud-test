package com.qf.repo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class ShBook implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField("BOOK_NAME")
    private String bookName;

    @TableField("ISBN")
    private String isbn;

    @TableField("PRICE")
    private Integer price;

    @TableField("STOCK")
    private Integer stock;


}
