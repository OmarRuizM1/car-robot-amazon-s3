package com.example.carrobotamazons3.batch

import com.example.carrobotamazons3.amazons3.AmazonS3Service
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.listener.JobExecutionListenerSupport
import org.springframework.stereotype.Component

@Component
class JobListener(private val amazonS3Service: AmazonS3Service, private val resourceConfig: ResourceConfig) : JobExecutionListenerSupport() {

    private val log: Logger = LoggerFactory.getLogger(JobListener::class.java)

    override fun beforeJob(jobExecution: JobExecution) {
        log.info("***STARTING JOB MY FRIEND***")
        resourceConfig.ouputFileResource().file.delete()
    }

    override fun afterJob(jobExecution: JobExecution) {
        if (jobExecution.status == BatchStatus.COMPLETED) {
            log.info("***FINISHED JOB MY FRIEND***")
        }
        log.info(String.format("***UPLOADING: %s TO AMAZON S3***", resourceConfig.outputResource))
        amazonS3Service.upload(resourceConfig.ouputFileResource().filename + System.currentTimeMillis(), resourceConfig.ouputFileResource().file)
    }
}