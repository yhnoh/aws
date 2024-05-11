1. Ubuntu에 AWS SystemManager Agent 설치
```sh
## ssm agent 설치
sudo snap install amazon-ssm-agent --classic

## ssm agent 설치 확인
sudo snap list amazon-ssm-agent

## ssm agent 실행
sudo snap start --enable amazon-ssm-agent

## ssm agent 실행 확인
sudo snap services amazon-ssm-agent

```

> [AWS > Linux용 EC2 인스턴스에 수동으로 SSM Agent 설치 및 제거](https://docs.aws.amazon.com/ko_kr/systems-manager/latest/userguide/manually-install-ssm-agent-linux.html) <br/>
> [AWS > SSM Agent 업데이트 자동화](https://docs.aws.amazon.com/ko_kr/systems-manager/latest/userguide/ssm-agent-automatic-updates.html)

2. Ubuntu에 AWS CLI 설치
```sh
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
sudo apt install unzip
unzip awscliv2.zip
sudo ./aws/install
aws --version
```

> [AWS > 최신 버전의 AWS CLI설치 또는 업데이트](https://docs.aws.amazon.com/ko_kr/cli/latest/userguide/getting-started-install.html)

3. SystemManager와 CloudWatch Agent를 사용하기 위한 역할 구성

- 역할에 필요한 정책
    - AmazonSSMManagedInstanceCore
    - CloudWatchAgentServerPolicy
- EC2 > IAM 역할 수정을 통해서 생성한 역할 연결

> [AWS > Systems Manager에 대한 인스턴스 권한 구성](https://docs.aws.amazon.com/ko_kr/systems-manager/latest/userguide/setup-instance-permissions.html) 

4. SystemManager를 사용하여 CloudWatch Agent 다운로드 및 구성

- SystemManager > 노드 관리 > 플릿 관리자에서 EC2에 SSM 설치가 되었는지 확인
- CloudWatch Agent를 설치하기 전에 System Manger를 이용하여 EC2가 명령을 수행하는지 확인
  - 노드관리 > 명령실행 > 명령문서 (AWS-RunShellScript)
  - 이후 확인을 위한 쉘 스크립트 작성
- System Manager의 명령실행을 이용하여 CloudWatch Agent 다운로드
  - 명령 문서 (AWS-ConfigureAWSPackage)
  - Name 입력란에 `AmazonCloudWatchAgent`를 입력이후 명령 실행
  - 명령 수행 완료 이후 EC2 인스턴스에 접속하여 CloudWatch Agent 상태 확인
    - `systemctl status amazon-cloudwatch-agent`
- System Manager의 명령실행을 이용하여 CloudWatch Agent 실행
  - 명령 문서 (AmazonCloudWatch-ManageAgent)
  - Action 선택란에 start를 선텍한 이후 명령 실행
  - 명령 수행 완료 이후 EC2 인스턴스에 접속하여 CloudWatch Agent 상태 확인
    - `systemctl status amazon-cloudwatch-agent`
- System Manager 파라미터 스토어에 amazon-cloudwatch-agent 설정 정보 등록
  - [amazon-cloudwatch-agent.json](./amazon-cloudwatch-agent.json)
- System Manager 파라미터 스토어 및 명령 실행을 이용하여 Cloudwatch Agent 설정 정보 등록
  - 명령 문서 (AmazonCloudWatch-ManageAgent)
  - Action 선택란에 configure를 선텍
  - Optional Configuration Location에 파라미터 스토어에 등록한 이름 입력이후 명령 실행
    - EC2 인스턴스에 접속하여 `/opt/aws/amazon-cloudwatch-agent/etc/amazon-cloudwatch-agent.d`로 이동 후, 설정정보가 변경되었는지 확인
- AWS CloudWatch에 들어가서 지표가 잘 수집되고 있는지 확인


> [AWS > CloudWatch 에이전트 다운로드 및 구성](https://docs.aws.amazon.com/ko_kr/AmazonCloudWatch/latest/monitoring/download-CloudWatch-Agent-on-EC2-Instance-SSM-first.html)<br/>
> [AWS > 수동으로 CloudWatch 에이전트 구성 파일 생성 또는 편집](https://docs.aws.amazon.com/ko_kr/AmazonCloudWatch/latest/monitoring/CloudWatch-Agent-Configuration-File-Details.html)<br/>
> [AWS > CloudWatch 에이전트가 수집하는 지표](https://docs.aws.amazon.com/ko_kr/AmazonCloudWatch/latest/monitoring/metrics-collected-by-CloudWatch-agent.html)



