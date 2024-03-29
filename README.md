<details>
<summary>1회차 : 자동차 경주 (Click) </summary>


# (1회차) 자동차 경주 🚗 🏁

## ✅ 구현 목록 : 체크 리스트

❗ 가장 최신으로 업데이트된 기능은 **(<span style="color:red">New</span>)** 접미사가 포함됨

---

### `RacingController.class`

- [x] 유저의 입력값을 받아 메인 서비스(`RacingGame`)를 호출하여 결과값을 전달받아 출력해주는 매개체

### `Cars.class`

- [x] 경주에 참가하는 자동차의 대수 만큼 Car 인스턴스 추가 (`joinCars()`)
- [x] 자동차의 움직이는 메서드(`move()`)
- [x] 가장 높은 점수의 자동차 유저를 찾는 메서드 (`getWinnerNames()`) (**<span style="color:red">New</span>**)

### 입출력 클래스

- [x] 입력 클래스 (`InputView.class`)
  - [x] 자동차 이름 입력
    - [x] 복수개의 자동차는 ','를 기준으로만 구분 가능 (**<span style="color:red">New</span>**)
    - [x] 자동차 1개의 이름은 5를 초과할 수 없음 (**<span style="color:red">New</span>**)
  - [x] 움직임 회수 입력
    - [x] 입력값이 숫자가 아니거나 0 이하의 값일 경우 재입력 요청
- [x] 출력 클래스 (`ResultView.class`)
  - [x] 전진하는 자동차를 출력할 때 이름을 같이 출력 (**<span style="color:red">New</span>**)
  - [x] 최종 우승자 이름을 출력 (**<span style="color:red">New</span>**)

### `Car.class`

- [x] 점수를 가짐 (= 자동차의 위치) (**<span style="color:red">New</span>**)
- [x] move()를 호출하여 자동차의 움직임 여부를 결정
  - 이때 움직임을 결정하는 핵심 로직은 `전략 패턴` 사용 (`CarMovementStrategy.class`)

### 테스트 코드

- [x] `CarsTest.class`
- [x] `CarTest.class`

### 컨벤션

- [x] Java : Intellij idea Code Style java 적용
- [x] Commit : AngularJS Commit Message 사용

### 코드 규칙

- [x] else 예약어 사용 X
- [x] switch / case 사용 X
- [x] index의 들여쓰기 depth는 1회까지 허용 (**<span style="color:red">New</span>**)
- [x] 함수(또는 메서드)의 길이가 15라인을 넘지 않도록 작성  (**<span style="color:red">New</span>**)

</details>

# STEP 2 : 로또 (자동)

## ✅ 구현 목록

---
## Main
### `lotto.java`
- [x] InputView, OutputView 객체를 사용하여 입력값에 따른 로또 생성 및 출력을 담당
  - [x] 이때 모든 입력값에 대한 결과 타입은 `String`으로 반환하며, 이를 어떻게 변환하여 어떠한 로또로 생성할지는 각 객체에게 위임
 
## Generator
### `LottoGenerator.java`
- [x] 주입된 로또 전략에 따라 로또를 생성
  - [x] 주입된 로또 전략이 없을 경우 에러 반환

### `LottoGeneratorStrategy.java`
- [x] 로또 생성을 담당하는 인터페이스
- [x] 일급 컬렉션 적용

### `ManualLottoGeneratorStrategy.java`
- [x] 수동로또 생성 클래스
  - [x] `LottoGeneratorStrategy.java`를 상속받음

### `RandomLottoGeneratorStrategy.java`
- [x] 자동로또 생성 클래스
  - [x] `LottoGeneratorStrategy.java`를 상속받음

## Model
### `LottoNumber.java`
- [x] 로또의 번호 1개를 가진 클래스
  - [x] 해당 번호의 유효성 검사 방어 로직 적용

### `Lotto.java`
- [x] 주입된 `Set<LottoNumber>`, `Random`=(랜덤 로또 생성에 사용), 또는 `List<String>`을 따라 로또를 생성
  - [x] 중복없이 6개의 숫자로 1~45 범위에서 로또를 생성하는지 체크하는 방어 로직 적용
  - [x] `containsNumber` 메서드를 통해 파라미터로 주어진 번호가 자신의 로또 번호에 있는지 판단

### `LottoMachine.java`
- [x] 구매한 수동 로또의 번호와 구입 금액만큼 로또를 생성
  - [x] 수동 로또는 수동 로또 생성 전략패턴을 사용하여 생성
  - [x] 자동 로또는 전체 구매 개수에서 수동 로또의 구매 개수만큼 차감하여 생성
    - [x] 이때 자동 로또는 전략 패턴에 따라 생성

### `WinningLotto.java`
- [x] 당천 번호와 보너스 번호를 받아 `Lotto` 클래스로 저장
  - [x] 이때 당첨 번호와 보너스 번호는 각각 따로 저장
  - [x] 이때 당첨 번호와 보너스 번호의 중복 여부를 체크
- [x] 당첨 번호와 유저가 구입한 로또를 비교하여 상금을 받는 로또의 정보를 반환하는 `countMatchedWinLottos()` 메서드 추가
  - [x] `EnumMap<PrizeEnum, Integer>`로 반환
  - [x] 이때 Key값은 당첨 숫자에 해당되는 `PrizeEnum` 객체를, value는 매칭된 번호 개수만큼 상금을 받는 로또의 개수
  
### `LottoProfit.java`
- [x] `LottoWinChecker`에서 얻게된 당첨 로또 정보를 통해 전체 상금을 구하는 객체
  - [x] 이때 당첨 금액은 `BigDecimal`로 저장 
- [x] 총 로또 구입 개수(=`numberOfTotalLottos`)를 파라미터로 받아 바로 위에서 구한 전체 상금과 나누어 최종적으로 얻게된 우승 상금을 반환하는 `calculateProfitRation()`도 존재
  - [x] 수익률은 `BigDecimal`로 반환

### `PurchaseAmount.java`
- [x] 로또의 구매 금액을 관리하는 클래스
  - [x] 전체 구매 로또 개수를 반환
  - [x] 구매 금액의 유효성 로직 적용
    - [x] 1000원보다 적은 금액으로 로또 구매시, 예외 출력
    - [x] 수동 로또의 개수가 전체 구매 로또 개수보다 많을 경우, 예외 출력

### `PrizeEnum.java `
- [x] 우승 번호와 매칭되는 로또 번호의 개수에 따른 `matchedCount`(= 매칭되는 번호 개수), `prize`(= 그에 따른 상금), `isBonusMatched` (= 보너스 번호 매칭 여부)의 정보들을 저장한 enum 클래스
  - [x] 매칭되는 숫자(= `matchedCount`)와 보너스 볼 존재 여부(= `isBonusMatched`)에 따라 `PrizeEnum`을 생성하는 `getPrizeFrom` 생성자 메서드 작성
- [x] `prizeMap`, `matchedCountToBonusMap`을 `static final Map`으로 생성하여 값을 찾을때마다 `PrizeEnum` 객체를 `Arrays.stream`하지 않도록 개선

## Exception
### `PurchaseException.java`
- [x] 구매 실패시 출력되는 예외

## View
### `InputView.java`
- [x] 로또 구매의 입력값을 받음
  - [x] 숫자 이외의 입력값을 막는 방어 로직 적용
  - [x] 1,000 단위의 구매값이 맞는지 체크하는 방어 로직 적용
  - [x] 구매값은 `string`으로 반환
- [x] 수동 로또의 구매 개수와 번호를 입력 받음
  - [x] 구매한 개수만큼, 입력된 수동 로또의 값에 따라 수동 로또를 생성
- [x] 로또 우승 번호의 입력값을 받음
  - [x] 6개의 숫자를 1~45 범위에서 받는지 체크하는 방어 로직 적용 
  - [x] 우승번호는 `List<String>`으로 반환
- [x] 로또 보너스 번호를 입력 받음
  - [x] 이때 로또 보너스 번호가 우승 번호와 중본된 값이 없는지 판단

### `ResultView.java`
- [x] 구매한 로또 개수를 출력
- [x] 구매한 자동로또를 모두 출력
- [x] 당첨된 로또의 정보를 출력
- [x] 최종 수익률을 출력

### 테스트 코드
- [x] `LottoGeneratorTest.java`
- [x] `LottoMachineTest.java`
- [x] `LottoNumberTest.java`
- [x] `LottoProfitTest.java`
- [x] `LottoTest.java`
- [x] `PrizeResultEnumTest.java`
- [x] `PurchaseAmountTest.java`
- [x] `WinningLottoTest.java`

### 컨벤션
- [x] Java : Intellij idea Code Style java 적용
- [x] Commit : AngularJS Commit Message 사용

### 코드 규칙
- [x] else 예약어 사용 X
- [x] switch/case 사용 X
- [x] indent의 들여쓰기 depth는 1회까지 허용
- [x] 함수(또는 메서드)의 길이가 15라인을 넘지 않도록 작성
- [x] 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현
- [x] 모든 기능을 TDD로 구현