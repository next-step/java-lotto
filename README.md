# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## To-Do - 문자열 계산기
## Done - 문자열 계산기
* 공백 기준으로 문자열 split - split 메소드
* 입력 값이 null / 빈 공백일 때 IllegalArgumentException 발생
* 덧셈 - Calculator의 add 메소드
* 뺄셈 - Calculator의 substract 메소드
* 곱셈 - Calculator의 multiply 메소드
* 나눗셈 - 정수로 나누어 떨어지도록 구현 - Calculator의 divide 메소드
* 사칙 연산 기호가 아닐 때 IllegalArgumentException 발생

## To-Do - 로또(2단계)
* 구입금액을 입력하라 -> InputView
* 구매 수를 출력하라 -> ResultView
* 로또 리스트를 출력하라 -> ResultView
* 지난 주 당첨 번호를 입력하라 -> InputView
* 당첨 통계를 출력하라 -> ResultView

* 로또 구매 수를 계산하라(구입 금액) -> LottoShop
* 로또 번호 객체 -> LottoNumber
* 로또 번호 세팅 -> LottoNumbers
* 로또 리스트 생성 -> Lotto
* 로또 리스트들 관리 -> Lottos
* 당첨 번호 리스트를 생성하라 -> WinNumber
* 당첨 번호와 로또 리스트들을 비교해서 일치 수를 알아내라 -> LottoMatch
* 수익률을 계산하라(구입 금액) -> Revenue

## To-Do - 로또(2단계)
* 보너스 번호 입력 -> InputView
* 보너스 번호 생성 -> Bonus
* 보너스 번호가 로또 번호에 포함되어있는지 확인 -> LottoMatch
* Rank enum이 일치 수와 상금을 가지도록 변경