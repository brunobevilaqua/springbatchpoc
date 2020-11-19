package com.test.springbatchpoc.job.file.delimitedfile.step.writer;

import com.test.springbatchpoc.job.file.fixedfile.Customer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DelimitedFileWriterConfig {

    @Bean
    public ItemWriter<Customer> delimitedFileWriter() {
        return items -> items.forEach(System.out::println);
    }

}
