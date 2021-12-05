# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 기능 요구 사항
* 로또를 진행하는 LottoGame class를 만든다.
  * InputView class를 이용해 구입금액을 입력받는다.
  * Lottos 일급 컬렉션을 통해 로또 번호를 자동으로 생성한다.
  * OutputView class를 이용해 생성된 로또 번호를 출력한다.
  * InputView class를 이용해 당첨 번호를 입력받는다.
  * LottoComparator class를 이용해 로또 번호와 당첨 번호를 비교한다.
  * StatisticGenerator class에 비교한 결과를 입력해 당첨 결과를 반환한다.
  * ProfitRateCalculator class로 수익율을 계산해 반환한다.
  * OutputView class를 이용해 당첨 통계를 출력한다.
* InputView class를 만든다.
  * 구입금액을 입력받는 함수를 구현한다.
  * 당첨 번호를 입력받는 함수를 구현한다.
* OutputView class를 만든다.
  * Lottos 일급 컬렉션을 받아 생성된 로또 번호를 출력하는 함수를 구현한다.
  * 당첨 결과를 출력하는 함수를 구현한다.
  * 수익률을 출력하는 함수를 구현한다.
* Lottos 일급 콜렉션을 만든다.
  * 로또 번호를 자동으로 생성해 Lotto 클래스에 저장한다.
  * 생성된 Lotto Instance를 list로 저장한다.
* Lotto class를 만든다.
  * 여섯 개의 번호를 list로 가진다.
  * 로또 번호화 당첨 번호를 비교해 LottoResult를 받는다.
* LottoResult class를 만든다.
  * 3개 일치~6개 일치까지의 개수를 member 변수로 저장한다.
  * 수익률을 계산하여 반환하는 함수를 만든다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 가산기 기능 요구 사항
* 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.
* 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
* 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.
* 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.
* “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.
* 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.