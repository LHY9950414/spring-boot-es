package example.es.controller;

import example.es.common.Result;
import example.es.service.Myindex000001Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor // lombok中的注解，不用在使用@Autowired, 必须是final
@RequestMapping("/demo")
public class Myindex000001Controller {

    private final Myindex000001Service myindex000001Service;

    @GetMapping("/getMyindex000001All")
    public Result getMyindex000001All(){
        return new Result(myindex000001Service.getMyindex000001All());
    }
}
