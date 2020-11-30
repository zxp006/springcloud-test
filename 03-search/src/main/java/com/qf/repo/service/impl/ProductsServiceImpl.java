package com.qf.repo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.repo.entity.Products;
import com.qf.repo.mapper.ProductsMapper;
import com.qf.repo.service.ProductsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxp
 * @since 2020-11-29
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements ProductsService {

}
