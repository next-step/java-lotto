# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 1단계 
### 사칙연산 계산기 기능 요구사항
  - 덧셈
  - 뺄셈
  - 곱셈
  - 나눗셈
- 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- 사칙 연산 기호가 아닌 경우 IllegalArgumentException throw

### 프로그래밍 요구사항
- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
- depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- method가 한 가지 일만 하도록 최대한 작게 만들어라.
- else를 사용하지 마라.

### 피드백 사항
- [x] 프로세스가 시작하는 클래스를 따로 만들기
- [x] DELIMITER를 상수로 빼기
- [x] tokenCount 사용하지 않고 operator / operand 나누기
- [x] 사용 가능한 기호를 Enum으로 Convert / 추상화하기
- [x] Calculator Class에서 splitTokens method 분리
- [x] OperateTest 중 유효한 기호 테스트 @ParameterizedTest 적용
- [x] 객체 상태 들고다니지 않기

# 2단계
### 로또(자동) 기능 요구사항
- 구입 금액을 입력한다
  - 금액은 1000원의 배수로 입력한다.
  - 1000의 배수가 아닐 경우 거스름돈을 거슬러준다.
- 로또 구매 갯수만큼 번호를 자동생성한다.
    - 자동 생성은 Collections.shuffle() 메소드를 활용한다.
    - 숫자는 1~45까지 랜덤한 번호이며, 중복없이 낮은 숫자로 정렬하여 반환한다.
- 지난 주 당첨번호를 입력한다.
  - 번호 6개를 ","로 구분하여 입력한다.
  - 번호가 6개가 아닐 경우 IllegalArgumentException을 반환한다.
  - 보너스 볼을 입력 받는다.
    - 보너스 볼은 기존의 6개의 번호와 중복될 수 없다.
    - 보너스 볼도 1~45 사이의 숫자여야한다.
- 당첨 통계를 계산한다.
  - 4등부터 1등까지 계산하여 결과를 반환한다.
  - 5개가 일치하고, 보너스볼이 일치할 경우 2등으로 계산한다. 
  - 총 수익률은 수익금/구매금액으로 계산하여 반환한다.

  ```
   당첨 통계
  ---------
  3개 일치 (5000원)- 1개
  4개 일치 (50000원)- 0개
  5개 일치 (1500000원)- 0개
  6개 일치 (2000000000원)- 0개
  총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
  ```
  
### 프로그래밍 요구사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### 피드백 사항
- [x] LottoBalls Stream API 적용
- [x] LottoBalls VO로 감싸기
- [x] LottoBalls 인라인 return
- [x] LottoBalls 메소드명 변경
- [x] LottoResult 클래스명 변경
- [x] MAP 대신 ENUM으로 다루기
- [x] 로또 가격 상수화
- [x] InputView에서의 당첨번호 validation 로또 번호 책임으로 변환
- [x] 반복문에서 LottoNumber로 감싸기
- [x] BonusNumber에 별다른 기능이 없을 시 삭제
- [x] LottoBalls 생성 시 초기 Balls를 static으로 구현
- [x] Rank 집계 시 BONUS_MATCHES 중복 filter로 거르기
- [x] bonusNumber 받지 않는 WinningNumber 생성자 삭제