package com.test.springbatchpoc.job.oddOrEven;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class OddOrEvenJobCOnfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job printOddOrEvenJob(Step printOddOrEvenStep) {
        return jobBuilderFactory
                .get("printOddOrEvenJob")
                .start(printOddOrEvenStep)
                .incrementer(new RunIdIncrementer()) // somente utilizar o incrementador quando o job nunca precisar ser reinicializado, caso contrario a cada execucao ele criara um novo id e nao sera possivel retomar o processamento na ultima instancia que ele parou!
                .build();
    }

}
