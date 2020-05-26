package com.example.carrobotamazons3.writers

import com.example.carrobotamazons3.batch.ResourceConfig
import com.example.carrobotamazons3.model.Car
import org.springframework.batch.item.file.FlatFileItemWriter
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor
import org.springframework.batch.item.file.transform.DelimitedLineAggregator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CarCSVWriter(private val resourceConfig: ResourceConfig) : CarWriter {

    @Bean
    override fun writer(): FlatFileItemWriter<Car> {
        val writer: FlatFileItemWriter<Car> = FlatFileItemWriter()
        writer.setResource(resourceConfig.ouputFileResource())
        writer.setAppendAllowed(true)
        writer.setLineAggregator(object : DelimitedLineAggregator<Car>() {
            init {
                setDelimiter(",")
                setFieldExtractor(object : BeanWrapperFieldExtractor<Car>() {
                    init {
                        setNames(arrayOf("id", "brand", "model", "color", "price"))
                    }
                })
            }
        })
        return writer
    }
}