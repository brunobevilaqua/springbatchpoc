package com.test.springbatchpoc.job.oddOrEven.step.processor;

import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountUntil10ProcessorConfig {

    @Bean
    public FunctionItemProcessor<Integer, String> countUntil10Processor() {
        return new FunctionItemProcessor<Integer, String>(item -> item % 2 == 0
                ? String.format("O número %s é par!", item)
                : String.format("O número %s é ímpar!", item));
    }

}
