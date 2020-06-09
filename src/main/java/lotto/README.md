# 2단계 - 로또(자동)
> https://edu.nextstep.camp/s/KDgLkV1d/ls/BzElcMyr

## 요구사항

### 프로그래밍 요구사항
* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다.
* indent depth는 2를 넘지 않는다.
* method 길이는 15라인을 넘지 않는다.
* 자바 코드 컨벤션을 지킨다.
* else 예약어를 쓰지 않는다.

### 로또란?
* 1~45까지의 숫자 가운데 6개를 고른다.
* 당첨번호도 같은 방식으로 숫자 6개를 고른다.
* 1등: 6개 번호 모두 일치
* 2등: 5개 번호 일치 + 나머지 1개가 보너스 번호 일치
* 3등: 5개 번호 일치

### 기능 요구사항
* 구입 금액을 관리하는 Price class
  * 0 이상의 숫자이다.
* 구입 금액을 입력 받으면 자동으로 6개의 숫자가 정해진다.
  * LottoNumber class
     * 숫자는 1 ~ 45 사이의 숫자이다.
     * 번호를 수동, 자동으로 생성해주는 정적 팩토리 메소드가 필요
     * public static LottoNumber generateByManual()
         * 테스트 가능한 부분
     * public static LottoNumber generateByAuto()
         * 불안정한 테스트로 인해 테스트 불가능한 부분
  * Lotto class
     * 중복없는 6개의 LottoNumber를 가진다.
     * public static Lotto generateByManual()
     * public static Lotto generateByAuto()
* 구입 금액에 따라 로또를 생성해준다.
  * LottoMachine class
     * 금액을 입력받으면 로또를 생성해준다.
     * 로또 1장의 가격은 1000원으로, 입력받은 금액/1000 = 로또 개수가 된다.
     * 거스름돈이 생기면 예외가 발생한다.
     * public List<Lotto> purchase(Price)
     * private int getLottoCount(Price)
     * private void validatePurchasable(Price)
* 구입 금액을 입력 받을 수 있다.
  * InputView class
     * public Price insertPrice()
* 자동으로 정해진 로또 번호들을 출력한다.
  * ResultView class
     * public void printLottoNumbers(Lotto)
* 당첨 번호 6개를 `,` 구분자로 입력 받는다.
* 순위에 따른 일치 개수 통계를 계산한다.
  * n개 일치할때의 상금에 대한 Prize enum class
     * 6개 일치 2000000000원, 5개 일치 1500000원, 4개 일치 50000원, 3개 일치 5000원, 나머지는 순위밖
  * LottoStatisticUtil class
     * 당첨번호와 구입한 로또를 입력받으면 당첨에 대한 통계를 출력한다.
     * 순위권만과 일치 개수를 출력
     * public int getPrizeCount(Prize, Lotto, List<Lotto>)
* 수익률을 계산한다.
  * LottoStatisticUtil class
     * public double getYield(Lotto, List<Lotto>)
* 일치 개수별 로또 개수 통계와 수익률 통계를 출력한다.
  * ResultView class
     * public void printStatistic(Lotto, List<Lotto>)

### Step4
* 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
* 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

* 개발 순서
    * 테스트 작성
      * 로또 생성시에 수동으로 입력받은 로또가 포함되어야 한다
      * 구입금액보다 수동 로또 금액이 크다면 예외발생
    * 수동으로 Lotto를 만들어주는 로직을 완성
      * LottoMachine > public List<Lotto> buy(Price price, List<Integer> ManualLottoNumbers)
    * input UI
      * 수동으로 구매할 로또 수를 입력해 주세요.
      * 수동으로 구매할 번호를 입력해 주세요.
    * output UI
      * 수동으로 3장, 자동으로 11개를 구매했습니다.
    * 리팩토링
