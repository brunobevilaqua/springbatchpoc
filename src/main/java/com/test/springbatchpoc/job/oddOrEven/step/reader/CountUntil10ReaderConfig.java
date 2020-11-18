package com.test.springbatchpoc.job.oddOrEven.step.reader;

import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CountUntil10ReaderConfig {

    @Bean
    public IteratorItemReader<Integer> countUntil10Reader() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return new IteratorItemReader<Integer>(numbers.listIterator());
    }

}
