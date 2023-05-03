package com.ssan.batch

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Configuration

@Configuration
// Spring Batch v5 이후 @EnableBatchProcessing이 필요 없어졌지만 테스트 프레임워크에선 필요하다.
// 사용하지 않을 경우 JobRepository 등 Spring Batch 기본 Bean이 생성 되지 않는다.
@EnableAutoConfiguration
@EnableBatchProcessing
class TestBatchConfig {
}