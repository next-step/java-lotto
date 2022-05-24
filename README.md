# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## 기능요구사항
(step1)
*사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
*입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
*나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
*문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
*예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

(step2)
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다
* 로또 당첨자를 추첨한다.
    ex)
    3개 일치 (5000원) - 1개
    4개 일치 (50000원) - 0개
    5개 일치 (1500000원) - 0개
    6개 일치 (2000000000원) - 0개
* 총 수익률을 출력한다.
ex)총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)

(step3)
* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통계에 2등도 추가해야 한다.
    ex)
    3개 일치 (5000원)- 1개
    4개 일치 (50000원)- 0개
    5개 일치 (1500000원)- 0개
    5개 일치, 보너스 볼 일치(30000000원) - 0개
    6개 일치 (2000000000원)- 0개

(step4)
* 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
    ex)
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
    ....

## 기능목록
(step1-문자열 계산기) 
* +계산기 
* -계산기
* *계산기 
* /계산기 (나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정)
* 입력값이 null이 거나 비었을기경우 예외처리(IllegalArgumentException)
* 입력값이 사칙연산 기호가 아닐경우 예외처리(IllegalArgumentException)
* 입력값이 잘못된 계산식일 경우 예외처리(IllegalArgumentException)

(step2-lotto(자동))
* 구입 금액 입력받는다.
* 구입금액에 해당하는 로또 개수 만큼 로또 번호 출력
* 당첨 번호 출력
* 당첨 번호와 일치하는 숫자가 3개이상인 명수와 당첨금 출력
* 수익률 출력

(step3-lotto(2등))
* enum을 사용하여 프로그래밍을 구현한다.
* 당첨자를 찾고, 맞춘개수가 5개라면 enum 타입 구분시 보너스번호까지 비교한다.

(step4-lotto(수동))
*lottos에 수동생성자를 추가한다.
    -lotto에 로또 개수 예외처리를 추가한다.
    -lotto에 로또 번호 중복 예외처리를 추가한다.
* 당첨자를 찾고, 맞춘개수가 5개라면 enum 타입 구분시 보너스번호까지 비교한다.
