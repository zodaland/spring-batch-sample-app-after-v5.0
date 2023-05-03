package com.ssan.batch.domain.sample

import com.ssan.batch.TestBatchConfig
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.test.JobLauncherTestUtils
import org.springframework.batch.test.context.SpringBatchTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBatchTest
@SpringBootTest(classes=[SampleJobConfiguration::class, TestBatchConfig::class])
class SampleIntegrationTestJobConfiguration @Autowired constructor(
    private val jobLauncherTestUtils: JobLauncherTestUtils
) {

    @Test
    fun 샘플_테스트() {
        //given
        val jobParameters: JobParameters = JobParametersBuilder()
            .addString("sampleParam", "1")
            .toJobParameters()

        //when
        println(jobLauncherTestUtils.job)
        val jobExecution: JobExecution = jobLauncherTestUtils.launchJob(jobParameters)

        //then
        Assertions.assertThat(jobExecution.status).isEqualTo(BatchStatus.COMPLETED)
    }
}