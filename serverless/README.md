

- AWS Lambda의 실행파일은 Amazon Linux에 호환되는 파일이어야 한다.
  - 실행파일이 Lambda에서 실행되는지 확인하려면 리눅스 환경을 구축하고 파일이 실행되는지 확인해보면 된다.
  - Lambda의 경우 런타임별로 Docker이미지를 제공하며, 이를 이용하여 테스트를 진행해볼 수 있다.
  - 외부 의존성에 의해 코드가 실패하는 것을 방지할 수 있다.
  - 
[AWS Lambda> 컨테이너 이미지를 사용하여 Lambda 함수 생성](https://docs.aws.amazon.com/ko_kr/lambda/latest/dg/images-create.html)
- [ECR > Lambda](https://gallery.ecr.aws/lambda/nodejs)
`curl -XPOST "http://localhost:8080/2015-03-31/functions/function/invocations" -d '{"payload":"hello world!"}'`

[Lamda Typescript 적용](https://velog.io/@wocks3/Lambda-typescript-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0)
[Serverless > Serverless.yml](https://www.serverless.com/framework/docs/providers/aws/guide/serverless.yml)

- 비용 산출

- 일반 적인 서버 개발
  - 가상 서버는 가용량을 고려하여 확보
    - 문제는 서버를 늘린 대수 만큼 가격을 지불해야한다. (요청이 적더라도)
    - 이를 해결하기 위하여 서버의 자동 규모 조절 장치도 추가해야 한다.
- 서버리스 기반의 서비스 개발
  - 이벤트에 의해 수행하고 그 결과를 반환
  - Amazon API Gateway를 이용하여 HTTP 이벤트를 생성
  - 