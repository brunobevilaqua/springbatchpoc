package com.test.springbatchpoc.job.file.fixedfile;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class FixedFileFormatJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job fixedFileFormatJob(Step readFixedFileStep) {
        return jobBuilderFactory
                .get("fixedFileFormatJob")
                .start(readFixedFileStep)
//                .incrementer(new RunIdIncrementer()) comentei para poder utilizar o retry
                .build();
    }

}
