### 서버 점검
- https://grip.news/archives/1366/

### 데이터베이스 업데이트 블루/그린 배포 사용
- [](https://docs.aws.amazon.com/ko_kr/AmazonRDS/latest/AuroraUserGuide/blue-green-deployments-switching.html)
- https://medium.com/@tomas94depi/database-migration-with-aws-rds-blue-green-deployments-9924f1e1fb39
- https://medium.com/vouchercodes-tech/rolling-back-after-an-amazon-rds-blue-green-deployment-ac804b44bf4f
- https://grip.news/archives/1366/
- 블루 -> 그린으로 전환되는 사이에 모든 DB 인스턴스카 read_only = true로 변경이 되면서 읽기 작업이 진행되지 않는다.
- 롤백을 어떻게 할지에 대한 생각도 해봐야한다.
### RDS 프록시
- [](https://docs.aws.amazon.com/ko_kr/AmazonRDS/latest/UserGuide/blue-green-deployments.html)

### RDS 파라미터 그룹 작업