package com.example.carrobotamazons3.writers

import com.example.carrobotamazons3.model.Car
import org.springframework.batch.item.support.AbstractFileItemWriter

interface CarWriter {
    /**
     * Return any implementation of AbstractFileItemWriter<Car>
     */
    fun writer(): AbstractFileItemWriter<Car>
}