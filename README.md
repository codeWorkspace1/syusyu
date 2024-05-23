# 슈슈 (syusyu) - 신발 쇼핑몰 프로젝트. 

### 개발기간
* ERD 설계 : 23.05.30 - 23.06.19 
* 개발 : 23.06.20 - 23.08.06

### 소개
#### 🌟 프로젝트 소개
* '슈슈'는 프랑스어 'chaussure'에서 유래한 이름으로, '마음에 드는 것'을 의미합니다.
* 사용자들이 다양한 스타일과 트렌드의 신발을 쉽게 탐색하고, 원하는 제품을 빠르고 효율적으로 구매할 수 있는 사이트를 제공하는 것입니다.

#### 💡 개발 방향
* 사용자 경험 중심 설계: 사용자의 편의를 최우선으로 하여 직관적이고 사용하기 쉬운 인터페이스 설계에 중점을 두었습니다.
* 효율적인 데이터 관리: DB 모델링 기법을 통해 데이터를 효과적으로 관리하고 사용자에게 맞춤형 경험을 제공합니다.

### 개발환경
#### 협업 및 관리도구
- Notion : 개발 일정, 회의록, 기술 문서, 칸바보드를 이용한 개발 우선순위 정리.
- WBS : 프로젝트의 각 작업을 세분화하여 팀원 간 업무 분배 및 일정 관리에 활용.

#### 개발도구
- IntelliJ IDEA: Java 및 Spring Framework 개발 환경
- Visual Studio Code: HTML, CSS, JavaScript, Sass 개발 및 프론트엔드 작업
- DataGrip: 데이터베이스 관리, 쿼리 작업 및 데이터 입력
- DBeaver: 데이터베이스 시스템 연결 및 관리함
- GitHub, Git : 소스코드 저장소와 버전관리
- Figma: 사용자 인터페이스 디자인
- draw.io: 데이터베이스 구조와 관계를 시각화하는 ERD (Entity-Relationship Diagram) 작성

#### 서버환경
- Apache Tomcat: 웹 애플리케이션 서버
- MySQL: 데이터베이스 관리 시스템

#### 기술스택
##### 프론트
- HTML/CSS/JavaScript
- jQuery
- Sass 
- Bootstrap: 관리자페이지에 디자인으로 구현
- Tabulator: 주문, 결제 테이블 기능으로 사용
- DataTables: 상품조회 테이블 플러그인으로 사용
- Summernote: 공지사항, 상품등록 에디터 사용
- DatePicker: 사용자 친화적인 날짜 선택 도구

##### 백엔드
- Java11/JSP
- Spring Framework 
- MyBatis: SQL 매핑 프레임워크로, 객체-관계 매핑(ORM) 제공
- JUnit: 단위 테스트
- Maven: 프로젝트 빌드 및 의존성 관리
- Apache Tiles: 웹 애플리케이션의 레이아웃 관리(top, side, footer 등)
- PortOne: 결제 시스템

### 설치 및 사용방법(환경설정)
1. MySQL 설치 및 설정
   - 공식 웹사이트에서 MySQL을 다운로드하고 설치합니다.
   - 설치가 완료되면, MySQL 서버를 시작합니다.
2. 제공한 SQL 덤프 Import
3. IntelliJ IDEA 다운로드 및 설치
   - JetBrains의 공식 웹사이트에서 IntelliJ IDEA를 다운로드하고 설치합니다.
4. 프로젝트 Git Repository 다운로드
5. IntelliJ IDEA에서 프로젝트 열기
6. MySQL 데이터베이스 연결
   - IntelliJ IDEA에서 데이터베이스 설정을 열고 MySQL 연결을 구성합니다.
   - 연결 정보 (호스트, 포트, 사용자 이름, 비밀번호)를 입력합니다.
7. Tomcat 서버 설정 및 연결
   - IntelliJ IDEA에서 Tomcat 서버를 설정합니다.
   - 'Run/Debug Configurations'에서 새로운 Tomcat 서버를 추가하고 프로젝트를 연결합니다.
8. 애플리케이션 실행
   - 설정된 Tomcat 서버를 사용하여 애플리케이션을 실행합니다.
  
### 팀원 역할
| 이름   | Front & Back             |
|:-----:|--------------------------------------------------------------------------------------|
| 이소윤 | 카테고리 메뉴, 메인 화면, 상품 리스트 조회, 관리자 상품 조회, 상품상세, 상품 장바구니 담기, 상품등록, 상품등록 내역|
| 방채민 | 주문 / 결제, 조회, 상세, 취소, 관리자 주문조회, 관리자 주문 상세, 확인, 발송관리, 배송처리|
| 한기선 | 공지사항 / FAQ / 리뷰 게시판 리스트, 등록, 수정, 삭제, 상세, 조회|
| 김수철 | 1:1문의 리스트, 조회, 등록, 답변등록|

### 주요기능 및 데모
* 공통 코드화: 코드의 재사용성을 높이기 위해 공통 코드화를 실시하여 팀원 간의 협업 효율성을 극대화했습니다..
* 경로 최적화: ViewPath 클래스를 사용하여 개발 과정에서 경로를 최적화하고, 이를 통해 애플리케이션의 성능과 유지보수성을 향상시켰습니다.
* JavaScript 네임스페이스 모듈화: JavaScript 코드의 구조화와 유지보수성을 향상시키기 위해 네임스페이스를 사용한 모듈화를 진행했습니다.

#### ERD
<img src="https://github.com/cdplayground/syusyu/assets/86580625/4394b1dc-c4d5-4e29-adb5-dd7e4b6cf129">


#### 메인화면



#### 발표영상
<a href="https://youtu.be/H8s0jUxJAV4?t=3">
    <img src="https://github.com/cdplayground/syusyu/assets/86580625/0eaf44cc-20cf-4127-9798-52349ad505c0" width="560" height="315" alt="발표영상">
</a>
