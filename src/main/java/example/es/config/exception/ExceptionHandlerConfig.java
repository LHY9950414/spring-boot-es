package example.es.config.exception;

import com.alibaba.fastjson2.JSON;
import example.es.common.Result;
import example.es.enums.StatusCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 异常处理配置
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandlerConfig {

    /**
     * 处理自定义异常
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(value = ESException.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest req, ESException ex){
        StringBuffer requestURL = req.getRequestURL();
        log.error("自定义异常捕获 requestURL -> {}, exception -> {}", requestURL.toString(), JSON.toJSONString(ex));
        return new Result(ex.getErrorCode(), ex.getErrorMsg());
    }

    /**
     * 处理空指针异常
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public Result exceptionHandler(@Valid HttpServletRequest req, NullPointerException ex){
        StringBuffer requestURL = req.getRequestURL();
        log.error("空指针异常捕获 requestURL -> {}, ex -> {}", requestURL, JSON.toJSONString(ex));
        return new Result(StatusCodeEnum.ERROR.getCode(), StatusCodeEnum.ERROR.getName());
    }

    /**
     * 处理参数校验异常
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest req, MethodArgumentNotValidException ex){
        StringBuffer requestURL = req.getRequestURL();
        log.error("参数校验异常捕获 requestURL -> {}, ex -> {}", requestURL.toString(), JSON.toJSONString(ex));
        BindingResult bindingResult = ex.getBindingResult();
        if(ex.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            if(!CollectionUtils.isEmpty(allErrors)){
                ObjectError objectError = allErrors.get(0);
                return new Result(StatusCodeEnum.VALID_ERROR.getCode(), objectError.getDefaultMessage());
            }
        }
        return new Result(StatusCodeEnum.VALID_ERROR.getCode(), StatusCodeEnum.VALID_ERROR.getName());
    }

    /**
     * 其它异常
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest req, Exception ex){
        StringBuffer requestURL = req.getRequestURL();
        log.error("其它异常捕获 requestURL -> {}, ex -> {}", requestURL.toString(), JSON.toJSONString(ex));
        return new Result(StatusCodeEnum.UNKNOWN.getCode(), StatusCodeEnum.UNKNOWN.getName());
    }
}
