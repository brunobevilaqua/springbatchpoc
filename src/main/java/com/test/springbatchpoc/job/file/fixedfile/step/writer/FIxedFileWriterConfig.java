package com.test.springbatchpoc.job.file.fixedfile.step.writer;

import com.test.springbatchpoc.job.file.fixedfile.Customer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FIxedFileWriterConfig {

    @Bean
    public ItemWriter<Customer> fixedFileWriter() {
        return items -> items.forEach(System.out::println);
//        return items -> {
//            for (Customer customer : items) {
//                if (customer.getName().equals("Maria"))
//                    throw new Exception();
//                else
//                    System.out.println(customer);
//            }
//        };
    }
}
