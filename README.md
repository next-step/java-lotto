# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## lotto(step1 - 문자열계산기) 기능 요구사항
- [x] 공백으로 구분해서 사칙연산을 수행할 수 있다.
- [x] 사칙연산이 아닌 경우 에러를 발생한다.
- [x] 나눗셈일 경우 0으로 나누면 에러를 발생한다.
- [x] 입력 값이 null이거나 빈 공백 문자일 경우 에러를 발생한다.
- [x] 입력 값 연산의 갯수가 짝수면 에러를 발생한다.

## lotto(step2 - 자동) 기능 요구사항
- 로또번호
    - [x] 중복된 값을 전달하면 예외를 던진다(중복되지 않은 숫자 6개여야 한다).
    - [x] 1이하이거나 45를 벗어난 숫자는 예외를 던진다(1 ~ 45 중의 숫자이어야 한다).
  
- 돈
    - [x] 금액이 1000원 단위가 아니면 에러가 발생한다.

- 로또번호 구매
    - [x] 해당 금액만큼 로또번호 리스트를 생성할 수 있다.

- 출력
    - [x] 구입금액을 입력받는다.
    - [x] 생성된 로또번호 리스트를 출력할 수 있다.
    - [x] 로또번호를 크기순으로 출력한다.
    - [x] 지난주 당첨 번호를 입력받는다.
    - [x] 당첨 통계를 출력한다.
    - [x] 수익률을 출력한다.

- 당첨결과
    - [x] 로또번호 1장 중에서 당첨번호가 몇 개 있는지 계산할 수 있다.
    - [x] 
    - [x] 당첨 통계를 낼 수 있다.
    - [x] 수익률을 계산할 수 있다.
