# 로또
## 프로그래밍 요구사항
* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
  * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
* 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
* else 예약어를 쓰지 않는다.

## 기능 나누기
- [x] 로또는 한 장당 1,000원이며 구입금액을 1,000으로 나눈 몫이 구입 개수이다.(1000원 미만 절삭)
- [x] 로또 한장은 6개의 난수를 생성하며 오름차순으로 저장된다.
- [x] 당첨번호는 정확히 6개여야한다.
- [x] 당첨 횟수에 따른 배당금을 지급한다.
- [x] 2등은 당첨 숫자 5개, 보너스 볼 1개를 맞아야한다. 
- [x] 보너스번호는 기존 당첨 번호와 중복될 수 없다.
- [x] 보너스번호 또한 로또 번호의 동일 범위를 가진다.

## 클래스별 역할
- `Dividend`
  - 로또를 맞춘 갯수에 따른 당첨금을 가지고 있는 enum class
  - 당첨 횟수에 따른 배당금 지급을 담당
- `Lottery`
  - 구매한 로또들과 당첨번호를 가지고 있는 class
  - 총 수입금과 총 수익률을 담당
- `LottoFactory`
  - 구입 금액을 가지고 있는 class
  - 로또의 생성, 난수 생성, 로또의 갯수를 담당
- `Lottos`
  - 구매한 로또들을 담고있는 class
  - 총 구매금액, 총 구매횟수, 로또들이 몇개 맞았는지 담당
- `Lotto`
  - 구매한 로또 한장의 번호들을 가지고 있는 class
- `WinnerNumbers`
  - 당첨번호를 가지고있는 class
  - 번호 하나를 받아 맞았는지 리턴하는 메소드 보유
- `LottoNumbers`
  - 로또 번호 6개를 담고있는 class 
  - 로또 번호의 갯수, 중복, 정렬을 담당
- `LottoNumberValidation`
  - 로또번호 하나의 Validation을 담당
- `BonusBall`
  - 보너스 번호를 가지고 있는 class
  - 보너스 번호를 리턴한다.
- `CorrectNumbers`
  - 당첨번호와 로또 번호가 얼마나 매치됐는지 정보를 가지는 class
  - 보너스 번호도 맞췄는지 검사한다.