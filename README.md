# [Spring Boot / JPA-Hibernate]

### 회원 데이터 관리 API

> 회원 데이터 CRUD 기능을 제공합니다.

-----

### 1. 개발 환경
#### 1-1. 시스템
  
    * Web Server : Apache
    
    * WAS : Spring Boot Embedded Tomcat(Servlet Container)
    
    * DB : Maria DB
    
#### 1-2. 소프트 웨어

    * JDK : JDK8 :: java-1.8.0
    
    * IDE : IntelliJ Ultimate Edition
    
    * Build Tool : Gradle
    
    * Persistence Framework : ORM(JPA-Hibernate)
    
    * Document Tool : Swagger
    
    * VSC : GitHub
    
-----

### 2. API 목록

<table>
  <tr>
    <td><b>API 분류</b></td>
    <td><b>API 상세 내역</b></td>
  </tr>
  <tr>
    <td rowspan="5">회원</td>
    <td>
      회원 전체 조회<br>
      GET/member/selectAll
    </td>
  </tr>
  <tr>
    <td>
      특정 회원 조회<br>
      GET/member/selectByMemberNo/{memberNo}
    </td>
  </tr>
  <tr>
    <td>
      회원 등록<br>
      POST/member/insert
    </td>
  </tr>
  <tr>
    <td>
      회원 수정<br>
      PUT/member/update
    </td>
  </tr>
  <tr>
    <td>
      회원 삭제<br>
      DELETE/member/delete/{memberNo}
    </td>
  </tr>
</table>

-----

### 3. Protocol Rule

> 표준 RESTful API 통신 방식을 따르며, HTTP Method, Resource URL 요청에 의해 JSON 응답 데이터로 반환됩니다.

#### 3-1. Resource URL

`{HTTP_METHOD} http://{host}/{resourcepath}`

<table>
  <tr>
    <td><b>URL 세그먼트</b></td>
    <td><b>설명</b></td>
    <td><b>예시</b></td>
  </tr>
  <tr>
    <td>"http://{host}"</td>
    <td>host address</td>
    <td>http://127.0.0.1:8989</td>
  </tr>
  <tr>
    <td>"{resourcepath}"</td>
    <td>Resource Path</td>
    <td>/member/selectMemberNo/{memberNo}</td>
  </tr>
</table>

#### 3-2. Response Data Type

 * Content-type : application/json
 
  ````JSON
    {
      "data":{
        "memberNo":1,
        ...
      }
    }
  ````  
 
 ### 3-3. API Response 성공 유무
 
 > Http Status Code 200 일시, 성공 그 외 모든값은 실패를 의미합니다. 실패 시 errorCode, errorMsg 반환되므로 확인이 필요합니다.

* 성공 : HTTP Status Code = 200, data object 반환
````JSON
200 : OK
    {
      "data":{
        "memberNo":1,
        ...
      }
      "retVal":0000,
      "retMsg":"성공"
    }
  ````  
  
* 실패 : HTTP Status Code <> 200, error object 반환
````JSON
500 : Internal Server Error
    {
      "retVal":0006,
      "retMsg":"회원번호 미 입력"
    }
  ````  
