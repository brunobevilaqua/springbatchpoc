package com.test.springbatchpoc.job.file.delimitedfile.step;

import com.test.springbatchpoc.job.file.fixedfile.Customer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DelimitedFileStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step delimitedFileStep(ItemReader<Customer> delimitedFileReader,
                                  ItemWriter<Customer> delimitedFileWriter) {
        return stepBuilderFactory
                .get("delimitedFileStep")
                .<Customer, Customer>chunk(1)
                .reader(delimitedFileReader)
                .writer(delimitedFileWriter)
                .build();
    }

}
