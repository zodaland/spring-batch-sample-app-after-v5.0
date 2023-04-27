package com.ssan.batch.domain.sample

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class SampleJobConfiguration (
    private val jobRepository: JobRepository,
    private val transactionManager: PlatformTransactionManager,
    private val tasklet: SampleTasklet
) {
    @Bean
    fun job(): Job {
        return JobBuilder("job", jobRepository)
            .start(step())
            .build()
    }
    @Bean
    fun step(): Step {
        return StepBuilder("step", jobRepository)
            .tasklet(tasklet, transactionManager)
            .build()
    }
}