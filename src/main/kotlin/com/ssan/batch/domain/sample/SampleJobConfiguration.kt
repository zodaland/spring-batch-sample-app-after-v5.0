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
        return JobBuilder("simpleJob1", jobRepository)
            .start(step())
            .build()
    }
    @Bean
    fun step(): Step {
        return StepBuilder("simpleStep1", jobRepository)
            .tasklet(tasklet, transactionManager)
            .build()
    }

    @Bean
    fun job2(): Job {
        return JobBuilder("simpleJob2", jobRepository)
            .start(step2())
            .build()
    }
    var count: Int = 0
    @Bean
    fun step2(): Step {
        return StepBuilder("simpleStep2", jobRepository)
            .chunk<String, String>(1, transactionManager)
            .reader {  ->
                if (count < 10) {
                    count++
                    return@reader count.toString()
                }
                return@reader null
            }
            .writer { items -> items.forEach { item -> println(item) } }
            .build()
    }
}