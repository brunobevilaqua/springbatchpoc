package com.test.springbatchpoc.job.file.delimitedfile.step.reader;

import com.test.springbatchpoc.job.file.fixedfile.Customer;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class DelimitedFileReaderConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<Customer> delimitedFileReader(@Value("#{JobParameters['customersDelimitedFile']}") Resource delimitedFile) {
        return new FlatFileItemReaderBuilder<Customer>()
                .name("delimitedFileReader")
                .resource(delimitedFile)
                .delimited()
                .names(new String[]{"name", "lastname", "age", "email"})
                .targetType(Customer.class)
                .build();
    }

}

