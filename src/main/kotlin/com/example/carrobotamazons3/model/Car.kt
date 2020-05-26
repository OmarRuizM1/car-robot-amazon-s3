package com.example.carrobotamazons3.model

data class Car(var id: Long, var brand: String, var model: String, var color: String, var price: Double){
    constructor(): this(0,"","","",0.0)
}
