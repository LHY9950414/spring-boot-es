package example.es.enums;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public enum StatusCodeEnum {

    OK(200,"成功"),
    VALID_ERROR(400,"请求参数错误"),
    ERROR(500,"服务器内部错误"),
    UNKNOWN(10000,"未知异常"),
    ;

    StatusCodeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Getter
    @Setter
    private Integer code;
    @Getter
    @Setter
    private String name;

    /**
     * 编码获取名称
     * @param code
     * @return
     */
    public static String getNameByCode(Integer code) {
        String result="";
        try {
            result= Arrays.asList(StatusCodeEnum.values()).stream().filter(e->e.getCode().equals(code)).findFirst().get().getName();
        }catch (Exception e) {
            log.error("枚举类StatusCode操作Exception -> e", e);
        }
        return result;
    }

}
