package com.test.springbatchpoc.job.helloworld.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldStepConfig {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    /**
     * Exemplo de Step utilizando tasklet
     *
     * @return
     */
    @Bean
    public Step printHelloWorldStep(Tasklet printHelloWorldTasklet) {
        return stepBuilderFactory
                .get("printHelloWorldStep")
                .tasklet(printHelloWorldTasklet)
                .build();
    }

}
