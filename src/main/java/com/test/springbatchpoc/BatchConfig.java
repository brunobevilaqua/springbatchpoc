package com.test.springbatchpoc;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job printHelloWorldJob() {
        return jobBuilderFactory
                .get("printHelloWorldJob")
                .start(printHelloWorldStep())
                .incrementer(new RunIdIncrementer()) // somente utilizar o incrementador quando o job nunca precisar ser reinicializado, caso contrario a cada execucao ele criara um novo id e nao sera possivel retomar o processamento na ultima instancia que ele parou!
                .build();
    }

    public Step printHelloWorldStep() {
        return stepBuilderFactory
                .get("printHelloWorldStep")
                .tasklet(printHelloWorldTasklet(null))
                .build();
    }

    @Bean // pra que se consiga obter dados do contexto da app
    @StepScope // para acessar o job parameters esse metodo tem que estar no escopo de um Step
    public Tasklet printHelloWorldTasklet(@Value("#{jobParameters['name']}") String name) {
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println(String.format("Hello World, %s!", name));
                return RepeatStatus.FINISHED;
            }
        };
    }

}
