# spring-batch-sample-app-after-v5.0
스프링 배치 5.0 이후 버전 적용을 위한 간단한 샘플 앱

# Tools
- kotlin 1.7.22
- jdk 17
- Spring Boot 3.0.5
- MySQL
- JPA

# Summary
- 현재 Java LTS 버전인 17 부터 지원한다.
- StepBuilderFactory, JobBuilderFactory가 Deprecated 되었으며 JobRepository를 명시적으로 사용하도록 권장한다.
- TransactionManager 또한 명시적으로 사용하도록 권장한다.
- @EnableBatchProcessing을 더이상 사용하지 않아도 된다. (혹은 않아야 한다.)
