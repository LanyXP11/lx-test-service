package com.lx.test.service.config;

import com.alibaba.dubbo.config.ReferenceConfig;
import com.lx.pk.dubbo.DubboConfigBuilder;
import com.lx.service.KafkaService;
import com.lx.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by chenjiang on 2018/12/20.
 */
@SuppressWarnings("all")
@Configuration
@PropertySource({"classpath:dubbo-reference-test-service.properties"})
public class KafkaServiceConfig {
    @Autowired
    private Environment env;

    @Autowired
    private DubboConfigBuilder builder;

    @Bean(name = "kafkaService")
    public KafkaService getServiceProxy() {
        return this.get(KafkaService.class, 10000);
    }

    private <T> T get(Class<T> cls) {
        String version = env.getProperty("dubbo.reference.lx-test-service.version");
        ReferenceConfig<T> reference = builder.build(cls, version);
        reference.setTimeout(5000);
        return reference.get();
    }


    private <T> T get(Class<T> cls, int timeout) {
        String version = env.getProperty("dubbo.reference.lx-test-service.version");
        ReferenceConfig<T> reference = builder.build(cls, version);
        reference.setTimeout(timeout);
        return reference.get();
    }

}
