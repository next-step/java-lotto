# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 계산기 기능 요구사항
* 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
* 입력 문자열의 숫자와 사칙 연산 사이에는 **반드시 빈 공백 문자열**이 있다고 가정한다.
* **나눗셈의 경우 결과 값을 정수**로 떨어지는 값으로 한정한다.
* 문자열 계산기는 **사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정**된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
* 예를 들어 `2 + 3 * 4 / 2`와 같은 문자열을 입력할 경우 `2 + 3 * 4 / 2` 실행 결과인 10을 출력해야 한다.

## 로또 기능 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.
* 로또는 1장에 6개의 숫자를 가지고 있다.
* 로또 숫자의 범위는 1부터 45까지다.
* 번호는 중복되지 않는다.

### LottoNumber
* 로또숫자는 1~45의 값만 가질수 있다.

### Lotto
* 로또숫자는 중복되지 않는다.
* 로또는 6개의 숫자를 가지고있다.
* 당첨번호가 몇개 일치하는지 반환한다.

### Lottos
* Lotto를 리스트로 가지고있다.
* 당첨번호개수별 개수를 센다.

### LottoNumberGenerator
* 로또숫자를 생성한다.

### LottoStore
* Controller 역할

### Match
* 로또가 몇개를 맞았는지 나타내는 enum
* 일치 개수별 금액과 메세지를 가지고있다

### Matchs
* 맞은 갯수별 맞은 로또의 수
* 총 당첨금을 계산한다.

### LottoBuyer
* 로또 구매자
* 로또를 산다.
* 돈을 받는다.
* 로또를 받는다.
* 당첨을 확인한다.
* 수익률을 계산한다.