package com.test.springbatchpoc.job.file.fixedfile.step;

import com.test.springbatchpoc.job.file.fixedfile.Customer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FixedFileFormatStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step readFixedFileStep(ItemReader<Customer> fixedFileReader,
                                  ItemWriter<Customer> fixedFileWriter) {
        return stepBuilderFactory
                .get("readFixedFileStep")
                .<Customer, Customer> chunk(1)
                .reader(fixedFileReader)
                .writer(fixedFileWriter)
                .build();
    }

}
