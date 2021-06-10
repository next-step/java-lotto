# 로또 수동

## 기능 요구 사항
현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

## 실행 결과
```
구입금액을 입력해 주세요.
14000

수동으로 구매할 로또 수를 입력해 주세요.
3

수동으로 구매할 번호를 입력해 주세요.
8, 21, 23, 41, 42, 43
3, 5, 11, 16, 32, 38
7, 11, 16, 35, 36, 44

수동으로 3장, 자동으로 11개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

## 프로그래밍 요구 사항
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) 을 원칙으로 한다.
  - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- else 예약어를 쓰지 않는다.
  - else 예약어를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
  - 힌트: if문에서 값을 반환하는 방식으로 구현하면 else 예약어를 사용하지 않아도 된다.
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 배열 대신 컬렉션을 사용한다.
- Java Enum을 적용한다.
- 모든 원시 값과 문자열을 포장한다
- 줄여 쓰지 않는다(축약 금지).
- 일급 컬렉션을 쓴다.

## Lotto Manual 구현 기능 목록
- [x] 사용자로부터 로또 구매 금액을 입력받는다.
- [x] 구매 금액만큼 로또 수량을 계산한다.
- [x] 사용자로부터 로또 수동 구매 갯수를 입력받는다.
- [x] 로또 수동 갯수와 로또 자동 갯수를 계산한다.
- [x] 로또 수동 갯수만큼 번호들을 입력받는다.
- [x] 로또 자동 갯수만큼 자동으로 번호를 생성한다.
- [x] 로또 객체들을 생성한다.

- [x] 사용자로부터 지난 주 로또 당첨번호와 보너스번호를 입력받는다.
- [x] 로또 번호들과 당첨번호와 보너스번호를 비교한다.
- [x] 로또 한 장마다 몇 개의 번호가 당첨번호와 동일한지 비교하여 센다.
- [x] 동일한 번호 갯수가 3개일 경우 5등, 4개일 경우 4등, 5개일 경우 3등 혹은 2등, 6개일 경우 1등이다.
- [x] 동일한 번호 갯수가 5개이고 보너스번호도 가지고 있다면 2등, 그렇지 않다면 3등이다.
- [x] 당첨 결과를 출력한다.
- [x] 총 수익률(당첨금액/구매금액) 을 계산하여 출력한다.

### lotto.mode.LottoNumber 의 기능
- (int) number
- `LottoNumber#LottoNumber` : 생성자
- `LottoNumber#checkNumber` : 1부터 45까지의 수인지 확인
- `LottoNumber#isSame` : 다른 LottoNumber 와 일치 여부
- `LottoNumber#getNumber` : getter

### lotto.model.Lotto 의 기능
- (List<LottoNumber>) lottoNumbers
- `Lotto#Lotto` : 생성자
- `Lotto#countWinningNumbers` : 당첨번호 포함 갯수
- `Lotto#contains` : LottoNumber 포함 여부
- `Lotto#getNumbers` : getter

### lotto.model.Lottos 의 기능
- (List<Lotto>) lottos
- `Lottos#Lottos` : 로또 자동 생성자
- `Lottos#Lottos` : 로또 수동 생성자
- `Lottos#createAutoLottos` : 로또 자동 생성
- `Lottos#createManualLottos` : 로또 수동 생성
- `Lottos#countWinningResults` : 당첨 결과 집계
- `Lottos#calculateEarningRate` : 총 수익률 집계
- `Lottos#getLottos` : getter

### lotto.model.AutoLotto 의 기능
- MIN_NUMBER
- MAX_NUMBER
- NUMBER_OF_LOTTO_NUMBERS
- (List<Integer>) numbers
- `AutoLotto#AutoLotto` : 생성자. 1부터 45까지의 숫자 생성
- `AutoLotto#createLottoNumbers` : 1부터 45까지의 숫자를 섞어서 자동으로 선택한 6개의 숫자를 로또번호들로 생성 

### lotto.model.ManualLotto 의 기능
- NUMBER_OF_LOTTO_NUMBERS
- `ManualLotto#createLottoNumbers` : 사용자로부터 입력받은 수동번호를 로또번호들로 생성
- `ManualLotto#splitBySeparator` : 문자열을 구분자로 분리
- `ManualLotto#addLottoNumbers ` : 분리된 문자열을 로또번호들로 변경

### lotto.model.LottoPrice 의 기능
- (int) price
- `LottoPrice#LottoPrice` : 생성자
- `LottoPrice#getPrice` : getter
- `LottoPrice#calculateLottoQuantity` : 로또 갯수 계산

### lotto.model.WinningLotto 의 기능
- (Lotto) winningNumbers
- (LottoNumber) bonusNumber
- `WinningLotto#WinningLotto` : 생성자
- `WinningLotto#getWinningNumbers` : getter
- `WinningLotto#getBonusNumber` : getter

### lotto.model.WinningResult 의 기능
- (int) winningAmount
- (List<Integer>) numberOfWins
- `WinningResult#WinningResult` : 생성자
- `WinningResult#addNumberOfWinning` : 당첨 횟수 저장
- `WinningResult#calculateEarningPrice` : 총 수익 계산
- `WinningResult#getWinningAmount` : getter
- `WinningResult#getNumberOfWins` : getter

### lotto.view.LottoManualInputView 의 기능
- `LottoManualInputView#inputPrice` : 사용자로부터 로또구매금액을 입력받는다.
- `LottoManualInputView#inputManualLottoQuantity` : 사용자로부터 로또수동갯수를 입력받는다.
- `LottoManualInputView#inputManualLottoNumbers` : 사용자로부터 로또수동번호들을 입력받는다.
- `LottoManualInputView#inputWinningNumbers` : 사용자로부터 당첨번호를 입력받는다.
- `LottoManualInputView#inputBonusNumber` : 사용자로부터 보너스번호를 입력받는다.

### lotto.view.LottoManualOutputView 의 기능
- `LottoManualOutputView#printLottos` : 사용자에게 로또 수동, 자동 구매갯수를 출력해준다. 사용자가 구매한 로또별로 6개의 번호를 출력해준다.
- `LottoManualOutputView#outputWinningResults` : 사용자가 구매한 로또들의 당첨 결과를 출력해준다.
- `LottoManualOutputView#outputEarningRate` : 사용자가 구매한 로또들의 총 수익률을 출력해준다.

### lotto.controller.LottoManualController 의 기능
- `LottoManualController#start` : 시작. 흐름 제어
- `LottoManualController#convertWinningNumbers` : 입력받은 당첨번호를 로또로 생성
