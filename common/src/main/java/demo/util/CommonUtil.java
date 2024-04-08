package demo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author xiao
 * @data 2024/4/8 8:25
 */
@Slf4j
public class CommonUtil {
    /**
     * 响应json数据给前端
     *
     * @param response response
     * @param obj obj
     */
    public static void sendJsonMessage(HttpServletResponse response, Object obj){
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json; charset=utf-8");
        try(PrintWriter writer = response.getWriter()){
            writer.print(Arrays.toString(objectMapper.writeValueAsBytes(obj)));
            response.flushBuffer();
        }catch (IOException e){
            log.warn("响应json数据给前端异常:{}", e);
        }
    }
}
