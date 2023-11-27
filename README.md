## STEP1 문자열 계산기
### 요구사항

사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 기능 목록

- [x] 숫자와 사칙연산 기호로 이루어진 문자열을 입력받는다.
- [x] 숫자나 기호가 아닌 값이 들어올 경우 exception
- [x] 기호가 숫자 사이에 위치하지 않을 경우 exception
- [x] 빈값이 들어왔을 경우 exception
- [x] 숫자와 사칙연산은 빈 공백 문자열로 스플릿된다.
- [x] 사칙연산은 수학의 계산 순서를 따르지 않고 입력순으로 한다.
- [x] 덧셈
- [x] 뺄셈
- [x] 곱셈
- [x] 나눗셈
- [x] 나눗셈은 결과값이 정수가 아닌경우 exception

## STEP2 로또(자동)
### 요구사항
로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
로또 1장의 가격은 1000원이다.

### 기능목록정리
- [x] 구매금액을 입력받는다.
- [x] 구매금액으로 로또를 n개 구입한다.
- [x] 구매한 로또당 숫자 6개를 랜덤으로 추출한다.
- [x] 당첨번호를 입력받는다.
- [x] 입력받은 당첨번호 문자열을 ','로 스플릿한다.
- [x] 당첨번호가 6개가 아닐 경우 exception
- [x] ','와 공백 그리고 숫자가 아닌 값이 들어왔을 경우 excpetion
- [x] 각 숫자는 1이상 45이하이다.
- [x] 당첨번호와 랜덤번호의 일치여부를 비교한다.
- [x] 3개 이상 일치한 경우 각 등수의 카운트를 구한다.
- [x] 구매금액 대비 당첨금액을 비교하여 수익율을 구한다.


## STEP3 로또(보너스)
### 요구사항
2등을 위해 추가 번호를 하나 더 추첨한다.
당첨 통계에 2등도 추가해야 한다.

### 기능목록정리
- [x] 보너스 넘버를 입력받는다.
- [x] 당첨번호 비교시에 보너스넘버 여부를 체크한다.
- [x] 6개의 당첨넘버 중에 보너스넘버가 포함되는 경우 2등으로 선정한다.


## STEP4 로또(수동)
### 요구사항
현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

### 기능목록정리
- [] 수동으로 처리할 번호 목록을 입력받는다.
- [] 구입금액이 수동으로 구매할 로또의 총액보다 작으면 exception