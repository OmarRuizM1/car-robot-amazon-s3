package com.example.carrobotamazons3.amazons3

import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AmazonS3Config {

    @Bean
    fun amazonS3Client(awsCredentialsProvider: AWSCredentialsProvider?, @Value("eu-west-1") region: String?): AmazonS3? {
        return AmazonS3ClientBuilder.standard().withCredentials(awsCredentialsProvider).withRegion(region).build()
    }
}