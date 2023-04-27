# spring-batch-sample-app-after-v5.0
스프링 배치 5.0 이후 버전 적용을 위한 간단한 샘플 앱

# Tools
- kotlin 1.7.22
- jdk 17
- Spring Boot 3.0.5
- MySQL
- JPA

# Summary
- StepBuilderFactory, JobBuilderFactory가 Deprecated 되었으며 JobRepository를 명시적으로 사용하도록 권장한다.
- TransactionManager 또한 명시적으로 사용하도록 권장한다.
- @EnableBatchProcessing을 더이상 사용하지 않는다.
