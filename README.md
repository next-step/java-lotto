# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 1단계 문자열 덧셈 계산기
## 기능 요구사항
* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6)
* 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## TODO
* [X] 빈 문자열 또는 null 값을 입력할 경우 0을 반환 (예 : "" => 0, null => 0)
* [X] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환 (예 : "1")
* [X] 숫자 두개를 컴마(,) 콜론(:)을 구분자로 입력할 경우 두 숫자의 합을 반환 (예 : "1,2", "1,2:3" => 6)
* [X] "//"와 "\n" 문자 사이에 커스텀 구분자를 지정하여 사용할 수 있음 (예 : "//;\n1;2;3" => 6)
* [X] 숫자 이외의 값이나 음수를 전달할 경우 RuntimeException 예외 발생 (예 : "-1,2,3")

# 2단계 - 로또(자동)
## 기능 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

## TODO
* [X] Lotto 도메인 클래스를 만든다. 들어온 숫자배열에 대해 검증을 해야한다. (배열 size 는 6, 중복된 값이 있는지)
* [X] AutoPurchaseStrategy 도메인 클래스를 만든다. 1~45 사이 6개의 정수형 변수를 요소로 가진 List 을 반환한다.
* [X] LottoMachine 클래스를 만든다. 구입전략과 구입금액을 입력받고 횟수에 따른 List<Lotto>를 생성 (구입금액에 대한 유효성 검사)
* [X] Rank Enum 클래스를 만든다. 당첨번호와 받은 Lotto 숫자를 대조하여 당첨여부를 확인한다.
* [X] LottoNumber 도메인 클래스를 만든다. 1~45 사이의 숫자인지 검증한다.
* [X] MatchingCount 도메인 클래스를 만든다.
* [X] Lottos 도메인 클래스를 만든다.
* [X] LottoMachine 클래스에 당첨통계 기능을 추가한다.
* [X] InputView UI 클래스를 만든다. 구입금액과 당첨번호를 입력받는다.
* [X] OutputView UI 클래스를 만든다. 당첨통계와 총 수익률을 보여준다.

# 3단계 - 로또(2등)
## 기능 요구사항
* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통계에 2등도 추가해야 한다.

## TODO
* [X] 전단계 피드백 반영
* [ ] WinningsStatistics 도메인 클래스를 만든다. LottoNumber 를 인스턴스변수로 가진다.
* [ ] Lottos, LottoMachine, LottoController - WinningsStatistics 추가에 따른 소스변경
