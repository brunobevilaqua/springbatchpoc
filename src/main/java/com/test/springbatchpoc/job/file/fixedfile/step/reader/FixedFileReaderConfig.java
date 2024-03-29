package com.test.springbatchpoc.job.file.fixedfile.step.reader;

import com.test.springbatchpoc.job.file.fixedfile.Customer;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class FixedFileReaderConfig {

    @StepScope
    @Bean
    public FlatFileItemReader<Customer> fixedFileReader(@Value("#{JobParameters['customerFile']}") Resource customerFile) {
        return new FlatFileItemReaderBuilder<Customer>()
                .name("fixedFileReader")
                .resource(customerFile)
                .fixedLength()
                .columns(new Range[]{new Range(1, 10), new Range(11, 20), new Range(21, 23), new Range(24, 43)})
                .names(new String[]{"name", "lastname", "age", "email"})
                .targetType(Customer.class)
                .build();
    }

}
