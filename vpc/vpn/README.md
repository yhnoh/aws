
### AWS Client VPN Endpoint 


- Client VPN 엔드포인트 설정시 고려해야할 사항
  - Clinet VPN 엔드포인트는 생성 후 변경 불가능
  - Client CIDR 범위는 최소 /22, 최대 /12
  - Clinet CIDR는 VPC의 주소 범위와 중첩될 수 없음
  - Client VPN 엔드포인트에서 지원할 최대 동시 연결 수를 고려하여 CIDR 블록 할당

- AWS Client VPN 클라이언트 인증
  - 상호 인증 (AWS Certificate Manager 인증서 기반)
  - 사용자 기반 인증 (AD 인증, SSO SAML 기반 연동 인증)


- AWS Client VPN 설정 요소
  - Target network associations
  - Autorization rule
  - 


- Client VPN 보안 그룹
  - Clinet VPN에서의 보안그룹의 의미는 Client VPN 접근 자체를 막기위한 용도가 아닌, 인증 받은 사용자가 VPN 내부 리소스의 접근을 제한하기 위하여 사용하는 용도이다.
  - Client VPN의 인증을 받은 사용자가 


- AWS VPN 접속 방식
  - 인증서 기반 접속 방식
    - 클라이언트와 서버간의 인증서를 기반으로 인증하는 방식

To generate the server and client certificates and keys and upload them to ACM


Target Network Associations
Security Group
Authorization rules

AWS Clinet

Upload the server certificate and key and the client certificate and key to ACM


[Youtube > AWS Client VPN 실습](https://www.youtube.com/watch?v=WzVER475EgA)
[AWS > AWS Client VPN 실습](https://catalog.workshops.aws/aws-vpn-at-a-glance/ko-KR/4-clientvpn)

[AWS > AWS Client VPN 다운로드](https://aws.amazon.com/ko/vpn/client-vpn-download/)
[AWS > AWS Client VPN 인가 설정](https://docs.aws.amazon.com/en_kr/vpn/latest/clientvpn-admin/client-authorization.html)


- 클라이언트 구성 파일 다운로드
- 

ㄹ

> [인증] https://docs.aws.amazon.com/en_kr/vpn/latest/clientvpn-admin/mutual.html
> https://docs.aws.amazon.com/en_kr/vpn/latest/clientvpn-admin/federated-authentication.html
> https://docs.aws.amazon.com/en_kr/vpn/latest/clientvpn-admin/client-authentication.html
> https://docs.aws.amazon.com/en_kr/vpn/latest/clientvpn-admin/split-tunnel-vpn.html
> https://docs.aws.amazon.com/en_kr/vpn/latest/clientvpn-admin/connection-logging.html
> https://blog.hbsmith.io/hbsmith%EA%B0%80-aws-client-vpn%EB%A1%9C-%EA%B0%88%EC%95%84%ED%83%84-%EC%9D%B4%EC%9C%A0-29119ecdc381
> https://kimalarm.tistory.com/69