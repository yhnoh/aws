## 1. CloudWatch

- CloudWatch는 AWS 리소스 및 AWS에서 실행되는 애플리케이션을 실시간으로 모니터링할 수 있다.
- AWS 리소스 및 애플리에케이션을 모니터링할 수 있는 ***지표를 수집***하고 해당 지표를 기반으로 ***대시보드 및 경보를 구성***할 수 있다.
  - CloudWatch를 통한 특정 지표에 대해서 추가 이벤트도 설정이 가능하다.
- CloudWatch를 기반으로 서비스를 어떻게 운영해야할지에 대한 의사결정 판단의 기준이되기 때문에 모니터링은 매우 중요하다.
  - CloudWatch를 사용하여 시스템 전체의 리소스 사용률, 애플리케이션 성능, 운영 상태를 파악

### 1.1. CloudWatch의 기본 용어

1. 지표 (Metric)
- 지표는 CloudWatch에 게시된 시간 순서별 데이터 요소 집합을 나타냅니다.
- 기본적으로 AWS 서비스들에 대하여 지표를 제공하고 있으며, EC2와 같은 일부 리소스에 대한 세부 모니터링이 가능하다.
  - 사용자 지정 지표도 생성이 가능
2. 네임스페이스 (Namespace)
- 네임스페이스는 CloudWatch 지표의 컨테이너 역할을 하며, ***다른 네임스페이스와 격리되어 있으므로 다른 애플리키에션의 지표가 동일한 통계로 집계되는 일이 없다.***
- AWS에서 수집하는 기본적인 지표는 `AWS/{서비스명}`형식이며, 사용자가 직접 수동으로 설정할 경우 필수로 입력해야한다.
3. 차원 (Dimension)
- 지표에 대한 키/값으로 이루어진 태그의 역할을 한다.
- 지표를 측정하기 위한 측정 기준으로 활용되며, 여러 리소스들중 내가 원하는 리소스 묶음들을 구분하기 위한 용도로도 활용된다.
  - AWS에서 사용하는 여러 리소스들을 특정 단위의 묶음으로 검색하고자 할 때, 차원을 활용하여 검색이 가능하다.
  - 일치하는 값 뿐만아니라 필터링하고자하는 값 또한 측정이 가능하다.
4. 경보
5. 

> [AWS > Amazon CloudWatch 개념](https://docs.aws.amazon.com/ko_kr/AmazonCloudWatch/latest/monitoring/cloudwatch_concepts.html#Dimension)

#### 1. 네임스페이스
- 
#### 1. 네임스페이스
#### 2. 지표
#### 3. 차원
#### 4. 

## 기본 정보

## 지표, 로그, 알람


> [AWS > CloudWatch 에이전트 설치](https://docs.aws.amazon.com/ko_kr/AmazonCloudWatch/latest/monitoring/install-CloudWatch-Agent-on-EC2-Instance.html) <br/>
> [AWS > 수동으로 CloudWatch 에이전트 구성 파일 생성 또는 편집](https://docs.aws.amazon.com/ko_kr/AmazonCloudWatch/latest/monitoring/CloudWatch-Agent-Configuration-File-Details.html) <br/>
> [AWS > CloudWatch 에이전트가 수집하는 지표](https://docs.aws.amazon.com/ko_kr/AmazonCloudWatch/latest/monitoring/metrics-collected-by-CloudWatch-agent.html) <br/>