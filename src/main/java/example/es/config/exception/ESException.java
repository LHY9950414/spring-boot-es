package example.es.config.exception;

import lombok.Data;

/**
 * 自定义业务异常
 */
@Data
public class ESException extends RuntimeException{

    public ESException(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    // 异常码
    private Integer errorCode;
    // 异常信息
    private String errorMsg;
}
