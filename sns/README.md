

## 메시지 필터링

- 기본적으로 Amazon SNS 구독자는 토픽에 올라온 메시지를 모두 수신한다.
- 


## SNS 메시지 전송 재시도

- SNS 구독자에게 메시지를 전달할 때, 서버쪽의 오류가 발생할 경우 전송 정책에 따라서 재시도가 이루어진다. 전송 정책 만큼 재시도를 하였지만 메시지를 전달하지 못하게될 경우 DLQ에 메시지를 전달하게 된다. 만약 DLQ를 사용하지 않는다면 해당 메시지를 삭제한다.
1. SNS 전송 정책 만큼 메시지 전송 재시도
2. DLQ에 메시지를 전달
3. DLQ를 사용하지 않을 시 메시지 삭제

### 전송 정책 단계
![](./img/sns%20_retry.png)

1. 즉시 재시도 단계 (Immediate Retey Phase)
- 첫 전송 시도 이후 지연시간 없이 즉시 재시도를 하는 단계이다.
2. 프리 백오프 단계 (Pre-Backoff Phase)
- 백오프 단계로 넘어가기전 지정된 지연시간 만큼 재시도한다.
3. 백오프 단계 (Backoff Phase)
- 재시도 백오프 함수를 사용하여 재시도 간 지연 시간을 제어한다.
- 최소 지연시간과 최대 지연 시간을 설정한 다음 재시도 백오프 함수를 사용하여 어느정도 간격으로 지연을 하여 재시도할지를 정의한다.
4. 포스트 백오프 단계 (Post-Backoff Phase)
- 백오프 단계 이후 지정된 지연시간 만큼 재시도한다.

- 구독자에게 전송하는 프로토콜에 따라서 전송 정책이 결정되며 해당 내용은 아래에서 확인할 수 있다.
    > [AWS SNS > 전송 프로토콜 및 정책](https://docs.aws.amazon.com/ko_kr/sns/latest/dg/sns-message-delivery-retries.html#delivery-policies-for-protocols)



> https://birdgang82.medium.com/aws-service-communication-amazonsns-dff3ab3b17b6