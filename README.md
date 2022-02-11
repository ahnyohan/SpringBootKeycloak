# SpringBootKeycloak
SpringBoot &amp; SpringSecurity &amp; keycloak


참조 : [https://www.baeldung.com/spring-boot-keycloak](https://www.baeldung.com/spring-boot-keycloak)


keycloak download  
[http://www.keycloak.org/downloads.html](http://www.keycloak.org/downloads.html)

1. 다운받은 폴더로 이동하여 압축해제.
2. 압축해제후 keycloak-{version}/bin으로 이동
3. ./standalone.sh -Djboss.socket.binding.port-offset=100 명령어로 실행

> port-offset 속성을 사용하면 지정한 번호를 추가하여 wildfly가 사용하는 모든 포트를 수정할 수 있습니다.
>
>
> 예를 들어 기본값은 `0`입니다. 즉, http 포트는 `8080`, remoting `4447`등이됩니다.
>
>  `${jboss.socket.binding.port-offset:100}`경우 http 포트는 `8180 (8080+100)`, 원격 `4547 (4447+100)`등이됩니다.
>

**포트를 직접 지정하여 WildFly 인스턴스를 시작하는 방법**

Windows :

```
standalone.bat -Djboss.http.port=1234

```

- linux,mac:

```
standalone.sh -Djboss.http.port=1234

```

*[http://localhost:8180](http://localhost:8180/) 으로 이동하면*  **관리자 로그인을 생성하기 위해 *http://localhost:8180/auth* 로 이동됨.**

1. 콘솔 관리자생성
2. realm생성
3. clients 생성
4. Roles 생성
5. Users 생성
   - Credentials 이동하여 password 설정
   - Role Mapping 이동하여 생성된 Roles를 Assinged

1. Keycloak 의 API로 token 발급

```
http://localhost:8180/auth/realms/SpringBootKeycloak/protocol/openid-connect/token

request body : www-form-urlencoded

client_id:<your_client_id>
username:<your_username>
password:<your_password>
grant_type:password
```

> 이슈발생. spring-boot 2.6.1  
> 오류내용 : The dependencies of some of the beans in the application context form a cycle  
> 해결:  
> SecurityConfig 에서 KeycloakSpringBootConfigResolver KeycloakConfigResolver 주석걸고  
> KeycloakConfiguration 추가함   
> 참조: https://stackoverflow.com/questions/70207564/spring-boot-2-6-regression-how-can-i-fix-keycloak-circular-dependency-in-adapte
