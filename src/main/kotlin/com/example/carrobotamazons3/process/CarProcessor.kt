package com.example.carrobotamazons3.process

import com.example.carrobotamazons3.model.Car

interface CarProcessor {
    /**
     * there can be several processes of input car and output car,
     * for example change the data to "uppercase" or any modification
     * that does not change to another input / output object
     */
    fun process(car: Car): Car
}