# 로또 Step2
## 기능 요구사항
### Lottery
- [x] 로또 번호를 저장하는 `List<Integer>`를 갖는 일급 콜렉션
- [x] `generate()` 메소드를 통해 로또 자동 생성 가능
  - 생성된 로또 번호는 오름차순 정렬해 보관
- [x] 로또의 최대 번호인 `lottery_NUM_MAX` 상수를 갖는다
- [x] 하나의 로또가 갖는 번호의 개수인 `lottery_NUM_COUNT` 를 갖는다
- [x] 주어진 `List<Integer>` 과 가지고 있는 `List<Integer>`가 **몇 개** 일치하는지 확인하는 메서드 `countEqualNumbers()` 메소드를 갖는다
- [x] 직접 리스트를 주입할 수 있는 생성자 지원
### LotteryWallet
- [x] `List<lottery>`를 갖는 일급 콜렉션
- [x] `generatelottery(count)` 메소드를 통해 새로운 `lottery`를 생성해 `List`에 추가 가능
- [x] 직접 리스트를 주입할 수 있는 생성자 지원
### Customer
- [x] `lotteryWallet`를 인스턴스 변수로 보유
- [x] `purchase(cashAmount)` 메소드를 통해 로또 구매 가능 - 구매한 로또 장수를 반환
### LotteryCompany
- [x] 로또의 당첨 여부 확인 메소드 `createlotteryResult(List<Integer> wonLotteryNumbers, lotteryWallet lotteryWallet)` 제공
  - [x] 지난주 당첨 번호를 입력받아 `Customer의 lotteryWallet`과 비교하여 결과 DTO 생성 후 반환
- [x] 로또 한 장의 가격과 각 등수의 당첨금을 상수로 관리
- [x] 주어진 금액으로 구매가능한 로또의 장수를 반환하는 `getAvailablePurchaselotteryCount(cashAmount)` 메소드 제공
### LotteryResult
- 로또 당첨 결과를 보관하는 DTO
- [x] 각 등수의 로또 장수와 가격 정보를 Map으로 저장
- [x] 로또 한 장 당 가격 저장 - `setlotteryPrice()`
- [x] 전체 구매한 로또 장수 저장 - `setTotalAmount()`
- [x] 인자로 주어진 등수에 맞는 로또 가격과 장수를 저장/반환하는 `set/getPrizeOf()`, `set/getWonCountOf()` 메서드 제공
- [x] 총 수익률을 계산해 반환하는 `getReturnRate()` 메서드 제공
### InputView
- [x] 로또 구매 금액 입력 받기
- [x] 지난 주 당첨 번호 입력 받기
### ResultView
- [x] 구매한 로또 번호 출력
- [x] 당첨 통계 출력
  - [x] 출력 DTO 사용

# Step3
## 리팩토링 요구사항
- [x] `LotteryRank`의 `getInstanceOfRank()` 메소드를 `valueOf()`로 변경
- [x] `LotteryRank`의 프로퍼티 `rank`를 `matchingCount`로 명확하게 변경
  - 타 클래스에서도 `일치하는 로또 번호의 개수`로 사용되는 변수의 이름을 `rank`에서 `matchingCount`로 변경
- [x] `LotteryRank`에 당첨되지 않은 로또에 해당하는 value `NONE(0, 0)`를 추가하고, `LotteryResult`의 `EnumMap`에 함께 저장하여 `totalPurchaseAmount`를 제거하고 계산으로 구하도록 변경
  - enum value의 이름도 등수(기존의 `rank`와 다름)로 변경 
- [x] `LotteryRank`에서 기존에 인자로 `rank(matchingCount)`를 받아 값을 반환하던 메소드들 `LotteryRank` 인스턴스를 받아 동작하도록 통일, 제거
  - [x] static 메소드들도 가능하면 인스턴스 메소드로 변경

## 기능 요구사항
- [x] 보너스 볼 입력받는 로직 추가 - `InputView`
  - [x] `WinningLottery`의 생성자가 보너스 볼을 같이 받도록 수정   
- [ ] 2등 (5개 일치 + 보너스 볼) 에 해당하는 `matchingCount`와 `prize`를 저장하는 enum value 추가
  - `4개 일치 이하` 및 `6개 일치` 의 경우 보너스 볼 일치 여부를 고려하지 않아야 함
  - [ ] 따라서 `WinningLottery`에 기존에 입력받은 로또 번호들과의 일치 여부 확인 이후 / 보너스 볼과의 일치 여부를 확인하는 로직을 별도로 추가 
  - [ ] `LotteryRank` 의 `valueOf(int matchingCount)` 메소드에서 인스턴스 생성을 위해 추가로 위에서 확인한 `보너스 볼과의 일치 여부`를 인자로 받도록 변경
- 결과적으로, `LotteryResult` 에는 `EnumMap`에 모든 정보가 담기게 됨\
  - [ ] `ResultView` 에서 출력하는 로직 변경 필요