package com.test.springbatchpoc.job.oddOrEven.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class OddOrEvenStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    /**
     * Exemplo de Step utilizando chunk
     *
     * @return
     */
    @Bean
    public Step printOddOrEvenStep(ItemReader<Integer> countUntil10Reader,
                                   ItemProcessor<Integer, String> countUntil10Processor,
                                   ItemWriter<String> countUntil10Writer) {
        return stepBuilderFactory
                .get("printOddOrEvenStep")
                .<Integer, String>chunk(1) // 1 registro por chunk, transações tem custo alto, logo deve-se testar e ver qual melhor numero utilizar. lembrar que quanto maior o chunk mais memoria sera utilizado e tempo de execucao.
                .reader(countUntil10Reader) // obrigatorio
                .processor(countUntil10Processor) // opcional
                .writer(countUntil10Writer) // obrigatorio
                .build();
    }

}
