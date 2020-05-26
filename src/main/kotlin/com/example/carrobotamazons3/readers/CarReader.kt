package com.example.carrobotamazons3.readers

import com.example.carrobotamazons3.model.Car
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader

interface CarReader {
    /**
     * Return any implementation of AbstractItemCountingItemStreamItemReader<Car>
     */
    fun reader(): AbstractItemCountingItemStreamItemReader<Car>
}