

### SNS 메시지 전송 재시도

- SNS 구독자에게 메시지를 전달할 때, 서버쪽의 오류가 발생할 경우 전송 정책에 따라서 재시도가 이루어진다.
-  Amazon SNS가 메시지 전송을 재시도하는 방식이 전송 정책에 따라 결정되며, 전송 정책만큼 재시도를 하였지만 메시지를 전달하지 못하였다면 DLQ에 메시지를 전달하게 된다. 만약 DLQ가 연결되어 있지 않다면, 해당 메시지를 삭제한다.  


![](./img/sns%20_retry.png)

[AWS SNS > 전송 프로토콜 및 정책](https://docs.aws.amazon.com/ko_kr/sns/latest/dg/sns-message-delivery-retries.html#delivery-policies-for-protocols) 을 통해서 각 구독자별로 어떤 전송 정책을 가지고 있는지 확인할 수 있다.



> https://birdgang82.medium.com/aws-service-communication-amazonsns-dff3ab3b17b6