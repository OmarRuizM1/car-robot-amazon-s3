package com.example.carrobotamazons3.readers

import com.example.carrobotamazons3.batch.ResourceConfig
import com.example.carrobotamazons3.model.Car
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CarCSVReader(private val resourceConfig: ResourceConfig) : CarReader {

    @Bean
    override fun reader(): FlatFileItemReader<Car> {
        return FlatFileItemReaderBuilder<Car>()
                .name("carCSVReader")
                .resource(resourceConfig.inputFileResource())
                .delimited()
                .names("id", "brand", "model", "color", "price")
                .fieldSetMapper(object : BeanWrapperFieldSetMapper<Car?>() {init {
                    setTargetType(Car::class.java)
                }
                }).build()
    }
}