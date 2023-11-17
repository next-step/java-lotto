# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## step1
### 기능 요구사항
### Done
- [x] 입력 값이 null이거나 빈 공백 문자일 경우 예외가 발생한다.(null || "" => throw IllegalArgumentException)
- [x] 사칙연산 기호가 아닌 경우 예외가 발생한다.(null || "" => throw IllegalArgumentException)
- [x] 사칙 연산 기호가 '+'면 숫자를 더한다. ("5 + 3" => 8)
- [x] 사칙 연산 기호가 '-'면 숫자를 뺀다. ("5 - 3" => 2)
- [x] 사칙 연산 기호가 '*'면 숫자를 곱한다. ("5 * 3" => 15)
- [x] 사칙 연산 기호가 '/'면 숫자를 나누고 정수만 리턴한다. ("5 * 3" => 1)
- [x] 여러 사칙 연산은 실제 사칙연산과 다르게 들어온 순서대로 계산한다. ("5 + 3 * 4" => 32)

---
## step2
### 기능 요구사항
### Done
- [x] 사용자는 구입 금액을 입력 할 수 있다.
- [x] 구입금액을 입력하면 금액에 해당하는 로또가 발급된다. (14000 => 14장)
- [x] 로또 1에서 45자리 사이의 번호가 오름차순 정렬되어 생성 된다. 
- [x] 사용자는 당첨 번호를 입력 할 수 있다.
- [x] 로또 등수 별 당첨 통계를 계산할 수 있다.
- [x] 로또 구매로 인한 수익률을 계산 할 수 있다.

## step3
### 기능 요구사항
- [x] 사용자는 보너스 볼을 입력 할 수 있다.
- [x] 당첨 통계에 2등이 추가된다.

## step4
- [x] 사용자가 수동으로 로또 번호를 입력 할 수 있다.