package com.example.carrobotamazons3.amazons3

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.PutObjectRequest
import com.amazonaws.services.s3.model.PutObjectResult
import com.amazonaws.services.s3.model.S3Object
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File

@Service
class AmazonS3Service(private val amazonS3Client: AmazonS3Client, @Value("\${app.awsServices.bucketName}") private val bucketName: String) {

    fun upload(filename: String?, file: File?): PutObjectResult {
        return amazonS3Client.putObject(PutObjectRequest(bucketName, filename, file))
    }

    fun download(fileName: String?): S3Object? {
        return amazonS3Client.getObject(bucketName, fileName)
    }

    fun delete(fileName: String?) {
        amazonS3Client.deleteObject(bucketName, fileName)
    }
}