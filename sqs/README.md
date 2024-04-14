### Amazon SQS 기본 아키텍처

- Publisher
    - 메시지 발행하기 (SendMessage)
- Consumer
    - 메시지 가져오기 (ReceiveMessage)
    - 메시지 삭제하기 (DeleteMessage)
    - 메시지 가져오기 취소 (DeleteMessage)

> [AWS > Amazon SQS 기본 아키텍처](https://docs.aws.amazon.com/ko_kr/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-basic-architecture.html)
> [AWS > Amazon SQS 제한 시간 초과](https://docs.aws.amazon.com/ko_kr/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-visibility-timeout.html)
> [Amazon SQS DLQ(Dead Letter Queue) 리드 라이브를 위한 새로운 API](https://aws.amazon.com/ko/blogs/korea/a-new-set-of-apis-for-amazon-sqs-dead-letter-queue-redrive/)
> https://channel.io/ko/blog/tech-backend-aws-sqs-introduction
> https://aws.amazon.com/ko/sqs/features/
> https://docs.aws.amazon.com/ko_kr/sqs/