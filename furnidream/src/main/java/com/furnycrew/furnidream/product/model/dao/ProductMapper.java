package com.furnycrew.furnidream.product.model.dao;

import com.furnycrew.furnidream.product.model.dto.ProductDto;

import java.util.List;

public interface ProductMapper {
    // 상품 전체 리스트
    List<ProductDto> findAll();
}