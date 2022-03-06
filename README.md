# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 목록

### StringCalculator
[x] , 또는 : 을 구분자로 가지는 문자열을 입력 받는다.
[x] Null이나 빈 문자열을 입력할 경우 0을 반환한다.
[x] 숫자 하나를 입력할 경우 해당 숫자를 반환한다.
[x] // 과 \n 를 모두 가지는 문자열이 들어오면 그 사이 문자를 구분자로 판단해서 입력 받는다.
[ ]// 과 \n 중 하나만 들어올 경우 Illegal Exception을 throw한다. [ERROR]  //, \n
[ ]// 과 \n 을 사용 시 그 사이에 커스텀 문자가 없을 경우 Illegal Exception을 throw 한다.
[ ]// 과 \n 을 사용하여 커스텀 구분자를 생성할 경우 \n 뒤의 문자열에 커스텀 구분자와 숫자 외의 문자열이 있으면 Illegal Exception을 throw한다.
[x] 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

### Lotto
[Wallet]
- 총 구매 금액을 저장한다.
[LottoPurchase]
[x] 총 구매 금액과 수동 구매 개수 전달 받아 수동 구매 개수와 자동 구매 개수를 저장한다.
[x] 구매 금액에 대한 validation을 적용한다.
    [x] 1000원 이하면 살 수 없음을 판단
    [x] 입력한 수동 개수만큼 살 수 있는지 판단
[HandLotto]
[ ] 수동 구매 로또를 저장한다.
[LottoMachine]
[ ] 자동 로또 개수를 받아서 자동 구매 로또를 생성해서 저장한다.
- 로또 한 장의 가격을 저장한다.
[WinningNumbers]
- 당첨 번호와 보너스 번호에 대한 validation을 수행한다.
[LottoJudgement]
- 수동로또와 자동로또와 당첨번호를 받아 LottoResult를 반환한다.
[NumberOfResults]
- 로또 결과를 받아 각각의 개수를 map으로 저장한다.
[WinningStatistics]
- 수익률 계산