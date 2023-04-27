package com.ssan.batch

//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//5.0 이후 사용하지 않는다.
//@EnableBatchProcessing
@SpringBootApplication
class BatchApplication

fun main(args: Array<String>) {
	runApplication<BatchApplication>(*args)
}
