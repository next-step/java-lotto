# 문자열 덧셈 계산기

## 기능 목록
- [x] 입력값을 구분자를 기준으로 분리할 수 있다. #Numbers 생성자
  - [x] `,`
  - [x] `:`
  - [x] `custom 구분자`
- [x] 빈 문자열이나 `null`을 입력하면 0을 반환한다.
- [x] 하나의 숫자만 입력한다면 숫자 그대로를 반환할 수 있다.
- [x] 숫자 외 문자가 들어온 경우 예외 발생 -
- [x] 구분자로 분리된 사용자의 입력을 덧셈 연산할 수 있다. - StringCalculator.calculate
- [x] 음수를 전달할 경우 `RuntimeException`이 발생한다. - validateNegative

---

# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 목록
-  [x] 값을 사용자로부터 입력받을 수 있다. - LottoInput
  - [x] 구입금액
  - [x] 당첨번호
  - [x] 보너스볼
- [x] 사용자에게 출력할 수 있다. - LottoInputView(입력 출력용), LottoResultView(결과 출력용)
  - [x] 구입금액
  - [x] 생성된 로또 번호
  - [x] 당첨번호
  - [x] 보너스볼
  - [x] 당첨통계
  - [x] 총수익률
- [x] 로또번호를 랜덤하게 생성할 수 있다. - LottoAutoGenerator
- [x] 당첨 통계를 계산할 수 있다. - LottoCalculator
- [x] 수익률을 계산할 수 있다. - LottoCalculator