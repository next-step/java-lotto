# Java Lotto

## Step1: String Calculator

### Requirements

#### 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.

- [x] 문자값 입력
- [x] 문자값 유효성 검증: Integer(숫자) 와 Operator(사칙연산) 만 입력받는다. 그렇지 않은 경우 에러

#### 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.

- [x] 문자값 유효성 검증: 각 Value(Integer, Operator) 는 빈 공백으로 구분된다.
- [x] 빈 공백으로 구분한 사이즈가 0 인경우 에러

#### 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.

- [x] 나눗셈의 결과값이 Integer가 아닌 경우 예외 처리
- [x] 0 으로 나눌 경우 예외 처리

#### 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.

- [x] 입력 순서대로 계산 수행

#### 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

- [x] equation 입력에 대한 결과 출력 테스트

### Todo

- [x] create classes Arithmetic, Value(Integer, Operator)
- [x] InputView, InputView
- [x] parse equation to Value, evaluateOperator, evaluateInteger
- [x] compute operators

### Result

```
Put your equation.
1 + 2 * 4 / 2 % 5
Result: 1
```

### Requested Changes

- [x] 요구사항 기능별 분리 작성
- [x] 미션에서 요구한 예제에 대한 테스트 추가
- [x] Operator Enum 으로 변경
    - [x] Operator 가 연산 부분을 포함하게?
- [x] operator parse 에 대한 성공과 예외 테스트 분리
- [x] InputView 역할 분리
- [x] 순차적 연산 방식 while with index에서 다른 방식으로 수정 -> Iterator.next
- [x] 축약된 변수명 수정
- [x] 한 단계의 indent만 수행

## Step2: Lotto auto

### Requirements

- 로또 구입 금액을 입력
    - [x] LotteryController 통해 전체 로직 관리
    - [x] LotteryController.money = InputView.scan
- 로또 1장의 가격은 1000원, money로 살 수 있는 로또 개수 연산
    - [x] LotteryController.numberOfLotterys = money / 1000
- 로또 객체 생성
    - [x] Lottery Class with box[45], numbers[6]
    - [x] Lottery.numbers 는 Collections.shuffle() 로 생성
- numberOfLotteries 만큼 Lottery class 생성
    - [x] for 1..numberOfLotteries: new Lottery()
    - [x] Collections.sort() 로 정렬해서 보관
- 자동으로 생성 된 로또 번호들을 출력
    - [x] ResultView.toString(lotto)
    - [x] ResultView.printLotteries
- 정답 번호를 입력
    - [x] LotteryController.answerNumbers = LotteryController.parse(InputView.scan)
- 정답 번호와 비교하여 win 횟수 세기
    - [x] for lotto of lotteries: lotto == answer ? cnt++ : null
    - [x] 비교는 ArrayList.contains() 활용
    - [x] WinStatistics Class 생성하여 3,4,5,6 field 에 save
- 당첨 통계 출력
    - [x] WinStatistics.toPayload 에서 출력할 문구 생성
    - [x] ResultView.printResult 에서 해당 문구를 출력
- 총 당첨 금액 계산
    - [x] winStatistics.getEarnedMoney
- 수익률 계산
    - [x] winStatistics.getEarningRate
- 수익률 출력
    - [x] ResultView.printEarningRate

### Result output

```
Put your money.
14000
14 lotteries are purchased.
[1, 8, 27, 37, 38, 45]
[6, 17, 19, 24, 25, 41]
[2, 21, 22, 29, 40, 44]
[4, 8, 26, 27, 31, 39]
[5, 8, 16, 19, 28, 41]
[2, 17, 18, 23, 25, 43]
[4, 6, 13, 15, 32, 43]
[8, 25, 33, 40, 41, 42]
[1, 7, 16, 26, 36, 37]
[1, 19, 26, 29, 34, 45]
[3, 9, 13, 15, 18, 42]
[3, 11, 17, 22, 36, 37]
[4, 13, 25, 28, 31, 36]
[17, 21, 22, 30, 31, 45]
Put lottery answer.
17, 21, 22, 28, 31, 36
Win Statistics
------------------
3 matches (₩5000): 2
4 matches (₩50000): 1
5 matches (₩1500000): 0
6 matches (₩2000000000): 0

Earning rate: Infinity
📈Earned! (More than 1.0 means 'Earned')
```

### Requested Changes

- [x] 1~45 box 생성 별도 분리
- [x] 로또 번호 생성 부분 별도 객체 분리해서 Lottery 에 전달
- [x] findWins를 반환 형태로 변환하여 테스트
    - 테스트는 작성하였으나 반환형태가 아닌 인스턴스 변수활용
- [x] 적자, 흑자 여부 출력
- [x] 로또 번호가 중복되지 않는 유일한 45개의 수인지 테스트 추가
- [x] 1000은 const 선언
- [x] MoneyTest에 로또는 장당 1000원으로 구매 할 수 있다에 대한 테스트를 추가
- [x] 로또 당첨 등급을 Map 대신 Enum을 사용해서 정의
- [x] 2단 indent 제거
- [x] 축약된 변수명 제거
- [x] Controller 포함 모든 Class 의 3개 이하로 인스턴스 변수 줄이기
- [x] 1단계 string_calculator 추가 수정
    - [x] 연산(계산식)도 BiFunction 을 활용해서 Operator Enum이 가지게 적용
    - [x] 상수와 멤버 변수의 선언 순서 변경
    - [x] Interface Value 제거
    - [x] Class Integer 제거
    - [x] step1: 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
- [x] step2: 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.

### Requested Changes phase2

- [x] BiFunction 를 무명 -> 유명 람다로 수정
- [x] WalletTest 의 객체를 개별로 선언하고 Given-When-Then 적용
- [x] money 를 객체로 포장
    - [x] money 에서 수익률 계산
- [x] Answer 대신 Lottery 사용
- [x] Reward.value -> money 변수명 수정, Money class 사용
- [x] Reward 가 당첨 번호 개수(win) 도 함께 포장
- [x] number 를 일일히 비교하는게 아닌 Lottery를 사용하여 matchNumber 수행
- [x] findWins 에서 saveWin(win) 을 분리
- [x] Lottery.shuffleBox()와 Lottery.findSixNumbers()를 LotteryBox 의 메소드로 이동
- [x] infinity, NaN 출력 에러 수정

## Step3: Lotto 2nd place

### Requirements

- [x] 2등 보너스 볼 추가 입력 받음
- [x] WinStatistics.matches 에 Reward 를 key 로 저장하게 수정
    - [x] Reward.toPayload 가 Reward.win 순으로 출력되게 수정
- [x] bonusBall 여부 Reward 에 추가
    - [x] Reward 가 bonusBall 을 가진 경우 바로 BONUS return
- [x] Remove Answer
- [x] Add Reward.BONUS test case
- [x] Remove double indent with stream

### Result output

```
Put your money.
14000
14 lotteries are purchased.
[7, 11, 33, 34, 35, 45]
[5, 10, 21, 22, 33, 38]
[4, 23, 33, 39, 41, 43]
[11, 27, 28, 29, 41, 43]
[9, 16, 24, 31, 34, 35]
[11, 27, 29, 35, 40, 43]
[5, 8, 14, 17, 30, 44]
[7, 9, 33, 35, 40, 43]
[4, 12, 22, 27, 33, 41]
[11, 13, 16, 22, 36, 38]
[4, 30, 31, 33, 37, 43]
[8, 9, 12, 15, 19, 34]
[4, 11, 22, 24, 26, 34]
[12, 18, 21, 22, 26, 37]
Put lottery answer.
12,18,21,22,26,36
Put bonus number.
37
Win Statistics
------------------
THREE matches (₩5000): 0
FOUR matches (₩50000): 0
FIVE matches (₩1500000): 0
BONUS matches (₩30000000): 1
SIX matches (₩2000000000): 0

Earning rate: 2142.8571428571427
📈Earned! (More than 1.0 means 'Earned')
```

### Requested changes

- [x] LotteryBox.findSixNumbers 안에서 shuffle 수행
- [x] 당첨번호 객체 분리 (answer, bonusNumber 포함)
- [x] 이름 변경 getEarningRate -> profitRate
- [ ] Money.didEarn -> ResultView 로 이동
- [ ] Reward.getMoney 제거
- [ ] Wallet은 로또 구매 갯수만 가지고 구매한 로또는 별도 저장
- [ ] Reward.of 로 2등 당첨 테스트 추가
- [ ] 로또 번호를 표현하는 일급 콜렉션 -> 로또 번호 발급
