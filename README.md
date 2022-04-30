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
- 수익률 계산
    - [ ] LotteryController.calculateEarningRate
- 수익률 출력
    - [ ] ResultView.printEarningRate

### Questions

- ResultView.print 로 출력을 모두 통일시킬 순 없을까?

### Result output
