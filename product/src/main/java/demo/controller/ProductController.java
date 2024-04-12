package demo.controller;

import demo.enums.BizCodeEnum;
import demo.interceptor.LoginInterceptor;
import demo.request.ProductRequest;
import demo.service.ProductService;
import demo.util.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author xiao
 * @data 2024/4/11 8:11
 */
@Api("商品模块")
@RestController
@RequestMapping("/api/product/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ApiOperation("分页查询商品列表")
    @GetMapping("page")
    public JsonData findProduct(
            @ApiParam(value = "当前页") @RequestParam(value = "page", defaultValue = "1") int page,
            @ApiParam(value = "每页显示多少条") @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        Map<String, Object> pageResult = productService.findProduct(page, size);
        return JsonData.buildSuccess(pageResult);
    }

    @ApiOperation("新增商品")
    @PostMapping("insert")
    public JsonData insertProduct(@ApiParam("商品对象") @RequestBody ProductRequest productRequest) {
        if (checkAuthority()) {
            return JsonData.buildResult(BizCodeEnum.ACCOUNT_NO_AUTHORITY);
        }
        int num = productService.insertProduct(productRequest);
        return JsonData.buildSuccess(num);
    }

    @ApiOperation("删除商品")
    @DeleteMapping("delete")
    public JsonData deleteProduct(@ApiParam("商品对象") @RequestBody ProductRequest productRequest) {
        if (checkAuthority()) {
            return JsonData.buildResult(BizCodeEnum.ACCOUNT_NO_AUTHORITY);
        }
        int num = productService.deleteProduct(productRequest);
        return JsonData.buildSuccess(num);
    }

    @ApiOperation("修改商品")
    @PostMapping("update")
    public JsonData updateProduct(@ApiParam("商品对象") @RequestBody ProductRequest productRequest) {
        if (checkAuthority()) {
            return JsonData.buildResult(BizCodeEnum.ACCOUNT_NO_AUTHORITY);
        }
        int num = productService.updateProduct(productRequest);
        return JsonData.buildSuccess(num);
    }

    @ApiOperation("健康检测")
    @GetMapping("health")
    public JsonData health() {
        return JsonData.buildSuccess();
    }

    private boolean checkAuthority() {
        int role = LoginInterceptor.threadLocal.get().getRole();
        return 30 <= role;
    }
}
