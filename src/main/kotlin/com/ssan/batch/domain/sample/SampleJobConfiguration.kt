package com.ssan.batch.domain.sample

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class SampleJobConfiguration {
    // Configuration 클래스 내 Job이 두개 이상 일 경우 test시 JobLauncherTestUtils에서 setJob을 통해 자동으로 Job을 등록 하지 못한다.
    /*
    @Bean
    fun job(jobRepository: JobRepository, step: Step): Job {
        return JobBuilder("simpleJob1", jobRepository)
            .start(step)
            .build()
    }
    @Bean
    fun step(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("simpleStep1", jobRepository)
            .tasklet(sampleTasklet(), transactionManager)
            .build()
    }

    @Bean
    @StepScope
    fun sampleTasklet(): Tasklet {
        return SampleTasklet()
    }
    */

    @Bean
    fun job2(jobRepository: JobRepository, step2: Step): Job {
        return JobBuilder("simpleJob2", jobRepository)
            .start(step2)
            .build()
    }
    var count: Int = 0
    @Bean
    fun step2(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
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