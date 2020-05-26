package com.example.carrobotamazons3.batch

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.core.io.FileSystemResource
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "csv")
data class ResourceConfig(
        var inputResource: String = "",
        var outputResource: String = ""
) {
    fun inputFileResource(): FileSystemResource {
        return FileSystemResource(this.inputResource)
    }

    fun ouputFileResource(): FileSystemResource {
        return FileSystemResource(this.outputResource)
    }
}