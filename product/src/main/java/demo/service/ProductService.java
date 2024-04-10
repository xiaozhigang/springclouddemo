package demo.service;

import demo.model.ProductDO;
import demo.request.ProductRequest;
import demo.util.JsonData;

import java.util.List;
import java.util.Map;

public interface ProductService {
    /**
     * 用户登录
     * @param page page
     * @param size size
     * @return JsonData
     */
    Map<String,Object> findProduct(int page, int size);

    int insertProduct(ProductRequest productRequest);

    int deleteProduct(ProductRequest productRequest);

    int updateProduct(ProductRequest productRequest);
}
