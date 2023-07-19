package com.teamProject.syusyu.service.product;

import com.teamProject.syusyu.domain.product.ProductDTO;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Map<String, Object> getProductList(int middleNo, int smallNo) throws Exception;

    Map<String, Object> getProductAllList(int middleNo) throws Exception;


    List<ProductDTO> getProductStatus(int[] prodId) throws Exception;

    ProductDTO getProduct(int prodId) throws Exception;
}
