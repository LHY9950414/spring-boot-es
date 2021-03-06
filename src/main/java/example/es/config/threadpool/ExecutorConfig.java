package example.es.config.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 配置ThreadPoolTaskExecutor线程池执行器
 */
@Slf4j
@EnableAsync
@Configuration
public class ExecutorConfig {
    private AsyncThreadProperties asyncThreadProperties;

    @Autowired
    public ExecutorConfig(AsyncThreadProperties asyncThreadProperties) {
        this.asyncThreadProperties = asyncThreadProperties;
    }

    @Value("${spring.application.name}")
    private String name;

    @Bean(name = "asyncServiceExecutor")
    public Executor asyncServiceExecutor() {
        log.info("start asyncServiceExecutor");
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(asyncThreadProperties.getCorePoolSize());
        //配置最大线程数
        executor.setMaxPoolSize(asyncThreadProperties.getMaxPoolSize());
        //配置队列大小
        executor.setQueueCapacity(asyncThreadProperties.getQueueCapacity());
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(name);
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
