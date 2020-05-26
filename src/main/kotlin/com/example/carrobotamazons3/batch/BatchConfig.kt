package com.example.carrobotamazons3.batch

import com.example.carrobotamazons3.model.Car
import com.example.carrobotamazons3.process.CarProcessor
import com.example.carrobotamazons3.process.CarUpperCaseProcessor
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableBatchProcessing
class BatchConfig(private val stepBuilderFactory: StepBuilderFactory, private val jobBuilderFactory: JobBuilderFactory) {

    @Bean
    fun processor(): CarProcessor {
        return CarUpperCaseProcessor()
    }

    @Bean
    fun job(jobListener: JobListener, step: Step): Job = jobBuilderFactory.get("job")
            .incrementer(RunIdIncrementer())
            .listener(jobListener)
            .flow(step)
            .end()
            .build()

    @Bean
    fun step(itemReader: ItemReader<Car>, itemProcessor: ItemProcessor<Car, Car>, itemWriter: ItemWriter<Car>): Step {
        return stepBuilderFactory.get("step")
                .chunk<Car, Car>(10)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build()
    }
}
