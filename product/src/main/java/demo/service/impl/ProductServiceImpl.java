package demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import demo.mapper.ProductMapper;
import demo.model.ProductDO;
import demo.request.ProductRequest;
import demo.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xiao
 * @data 2024/4/10 8:34
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Map<String, Object> findProduct(int page, int size) {
        Page<ProductDO> pageInfo = new Page<>(page, size);
        Page<ProductDO> productDOPage = productMapper.selectPage(pageInfo, null);

        Map<String, Object> pageMap = new HashMap<>(3);

        pageMap.put("total_record", productDOPage.getTotal());
        pageMap.put("total_page", productDOPage.getPages());
        pageMap.put("current_data", productDOPage.getRecords());

        return pageMap;
    }

    @Override
    public int insertProduct(ProductRequest productRequest) {
        ProductDO productDO = new ProductDO();
        BeanUtils.copyProperties(productRequest, productDO);
        return productMapper.insert(productDO);
    }

    @Override
    public int deleteProduct(ProductRequest productRequest) {
        return productMapper.deleteById(productRequest.getId());
    }

    @Override
    public int updateProduct(ProductRequest productRequest) {
        ProductDO productDO = new ProductDO();
        BeanUtils.copyProperties(productRequest, productDO);
        return productMapper.updateById(productDO);
    }

}
