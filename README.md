# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## step1 진행

### 미션 브리핑 & 제약사항
- 사용자가 입력한 문자열을 받아서 사칙연산을 수행할 수 있는 계산기를 구현해야한다
- 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다
- 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다

### 기능적 요구사항
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다
  - 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다
  - 예시) 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야한다
- 테스트할 수 있는 단위로 나누어 구현 목록 만들기
  - 덧셈 / 뺄셈 / 곱셈 / 나눗셈
- 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw 한다
- 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- 사칙 연산을 모두 포함하는 기능 구현한다
- 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
- 반복적인 패턴을 찾아 반복문으로 구현한다.

### 비기능적 요구사항
- indent(들여쓰기) depth를 1단계로 줄여야한다 (기존  2단계)
  - 예시) depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현
- method가 한 가지 일만 하도록 최대한 작게 만들기

### 기능적 요구사항을 만족하기 위한 테스트 목록
- (+) 계산한다
- (-) 계산한다
- (*) 계산한다
- (/) 계산한다
- 입력 값이 null이거나 공백 문자일 경우 IllegalArgumentException throw 한다
- 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- 문자열을 "2 + 3 * 4 / 2" 입력시 10을 반환한다


<br><br><br><br><br><br>



## Step2 로또(자동)

### 기능적 요구사항 분석
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또 응모권을 발급해야 한다.
  - 1000원마다 로또 응모권 한장을 발행한다
  - 응모권마다 6개의 번호를 지정한다::TicketTest
  - 발급수량만큼 응모권이 발행된다::MatchTest
- 당첨번호를 입력받아 당첨통계를 계산한다
  - 1등 담첨통계가 계산된다(6개 번호 일치)
  - 3등 당첨통계가 계산된다(5개 번호 일치)
  - 4등 당첨통계가 계산된다(4개 번호 일치)
  - 5등 당첨통계가 계산된다(3개 번호 일치)
- 수익률을 계산한다
  - 당첨금액을 계산한다
  - 투자금 대비 당첨금액의 비율을 0~1 사이의 소수점 둘째자리까지 표시한다
  
### 묵시적 요구사항 & 비기능적 요구사항 (테스트코드 없음)
- 로또 번호 사이의 구분자는 [, ] 이다 컴마와 공백문자 하나가 있어야 함
- 1000원 이하의 구매금액 입력시 프로그램 종료 >> 수익률 계산시 Div Zero 에러 발생할듯?
- 1000원 단위 절사, 1500원 입력시 500원 버림
- 손해일때 출력문구 : (손익분기점이 1이기 때문에 결과적으로 손해라는 의미임)
- 이득일떄 출력문구 : (손익분기점이 1이기 때문에 결과적으로 이득이라는 의미임)
- 로또 번호(랜덤)는 외부주입으로 테스트하기 쉽게 설계하기
  - 랜덤 번호 주입시 Sort 해서 넣기, 안그러면 매 2D ForLoop 돌기때문에 매우 비효율적
  - 랜덤 번호라고 해도 중복이 없어야하고, 꼭 6개가 필요하다는 점에서 List 보다 Set/HashSet 이 유리할듯?
    - 1 ~ 46 의 공이 있고 순서가 없이 뽑힐수 있다는 점에서 Set 이 도메인적으로 적절한 자료구조일듯? (정렬과 중복제거의 장점은 덤) 
- 구매번호-당첨번호-당첨내역 검증 : 해당 부분을 테스트할수 있는 구조로 작성해야함
- UI 레이어와 Domain 레이어는 분리



### 비기능적 요구사항
- 모든 기능을 TDD로 구현
  - 모든 기능은 단위 테스트가 존재한다




## Step3

```
테스트하기위한 Ticket 클래스 기능 정리

countMatchNumbers : 몇개 숫자가 일치하는지 알아내는 기능
WinnerTicket() : 위너티켓을 생성해주는 기능
countWinner(List<Ticket> challengeTickets, Prize prize) : 입력받은 리스트 티켓에, 입력받은 등수의 티켓이 몆장이 포함되어있는지 검증
```

### 학습해봐야할것
- 이펙티브자바 13 상속보타 컴포지션
- 일급 콜렉션 이란?


### 수정해야할부분
- Ticket#winnerTicket  : 단순히 Ticket이 WinnerTicket을 만들기 위한 역할로 알맞을지 고민해보시면 좋을 것 같아요~
- Tickets 라는 일급 콜렉션을 만들기