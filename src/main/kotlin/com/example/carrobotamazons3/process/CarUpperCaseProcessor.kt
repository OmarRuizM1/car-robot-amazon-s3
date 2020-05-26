package com.example.carrobotamazons3.process

import com.example.carrobotamazons3.model.Car
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.annotation.AfterStep
import org.springframework.batch.core.annotation.BeforeStep
import org.springframework.batch.item.ExecutionContext
import org.springframework.batch.item.ItemProcessor

class CarUpperCaseProcessor : CarProcessor, ItemProcessor<Car, Car> {

    private val log: Logger = LoggerFactory.getLogger(CarUpperCaseProcessor::class.java)
    private var executionContext: ExecutionContext? = null

    @BeforeStep
    fun beforeStep(stepExecution: StepExecution) {
        this.executionContext = stepExecution.executionContext
    }

    override fun process(car: Car): Car {
        countRows()
        return Car(car.id, car.brand.toUpperCase(), car.model.toUpperCase(), car.color.toUpperCase(), car.price)
    }

    @AfterStep
    fun afterStep(stepExecution: StepExecution?) {
        log.info(String.format("***PROCESSED ROWS: %d***", executionContext!!.getInt("rows")))
    }

    private fun countRows() {
        executionContext!!.putInt("rows", executionContext!!.getInt("rows", 0) + 1)
    }

}
