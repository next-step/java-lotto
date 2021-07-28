# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 문자열 덧셈 계산기를 통한 TDD/리팩토링 실습
## 기능 요구사항
- [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
  - [x] 입력값이 빈 문자열이거나 null 일 경우 0을 반환한다.
  - [x] 쉼표(,) 또는 콜론(:) 으로 인자를 분리한다.
  - [x] 분리된 인자를 모두 더한 값을 반환한다.
- [x] 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
  - [x] 구분자가 없다면 기본 구분자는 쉼표와 콜론이다.
  - [x] 커스텀 구분자는 // \n 사이에 위치한다.
- [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

# 로또
## 기능 요구사항
- [] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- [] 로또 1장의 가격은 1000원이다.
- [] 로또 한장의 가격 미만의 숫자가 들어온 경우 예외를 발생한다.
- [] 구입금액으로 몇 장을 구매했는지 반환한다.
- [] 로또 번호는 1에서 45 사이의 숫자이다.
- [] 로또 한장은 6개의 번호를 가지고 있다.
- [] 로또 한장에 번호는 중복될 수 없다.
- [] 당첨 번호는 6개의 번호로 이루어져 있다.
- [] 로또 한장은 당첨 번호가지고 비교하여 몇 등인지 반환한다.
- [] 3개 부터 6개 까지의 몇개가 일치하는지 확인하여 반환한다.
- [] 구입 금액대비 수익률을 반환한다.
