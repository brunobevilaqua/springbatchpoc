package com.test.springbatchpoc.job.oddOrEven.step.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountUntil10WriterConfig {

    @Bean
    public ItemWriter<String> countUntil10Writer() {
        return items -> items.forEach(System.out::println);
    }
}