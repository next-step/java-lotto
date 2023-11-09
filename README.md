<!-- TOC -->

* [로또](#로또)
    * [진행 방법](#진행-방법)
    * [온라인 코드 리뷰 과정](#온라인-코드-리뷰-과정)
    * [Step2](#step2)
        * [프로그래밍 요구사항](#프로그래밍-요구사항)
        * [기능목록](#기능목록)

<!-- TOC -->

# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## Step1

### 프로그래밍 요구사항

- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.[method가 한 가지 일만 하도록 최대한 작게 만들어라.]
- else를 사용하지 마라.

### 기능목록

- `사용자가 입력한 문자열 값`에 따라 `사칙연산을 수행할 수 있는 계산기를 구현`해야 한다.
    - [X] ~~덧셈~~
    - [ ] 뺄셈
    - [ ] 곱셈
    - [ ] 나눗셈
    - [X] ~~입력 값이 `null`이거나 `빈 공백` 문자일 경우, `IllegalArgumentException` 예외 발생~~
    - [X] ~~`사칙연산 기호`가 아닌 경우, `IllegalArgumentException` 예외 발생~~
    - [ ] `사칙 연산을 모두 포함`하는 기능 구현
- [X] ~~입력 문자열의 숫자와 사칙 연산 사이에는 `반드시 빈 공백 문자열이 있다고 가정`한다.~~
- [ ] 나눗셈의 경우, `결과 값을 정수로 떨어지는 값으로 한정`한다.
- [ ] 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 `입력 값에 따라 계산 순서가 결정`된다.
    - 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
    - 예를 들어 `2 + 3 * 4 / 2`와 같은 문자열을 입력할 경우, `10`을 출력해야 한다.

---
