# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Step1 : 문자열 계산기

### 문자열 사칙 연산 계산기 구현

- 이번 미션의 핵심은 내가 구현하는 코드에 단위 테스트를 추가하는 경험을 하는 것이다.
- 모든 예외 상황을 처리하기 위해 너무 복잡하게 접근하지 않아도 된다.

### 기능 요구사항

- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
- 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 프로그래밍 요구사항

- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
  - depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
  - method가 한 가지 일만 하도록 최대한 작게 만들어라.
- else를 사용하지 마라. 

### 기능 분리 힌트

- 테스트할 수 있는 단위로 나누어 구현 목록을 만든다. 
  - 덧셈
  - 뺄셈
  - 곱셈
  - 나눗셈
  - 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
  - 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
  - 사칙 연산을 모두 포함하는 기능 구현
- 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
- 반복적인 패턴을 찾아 반복문으로 구현한다.

### 기능 구현 진행사항

- 문자열 계산식 입력 담당 객체 (`Expression`)
  - [X] 입력 문자열이 빈 값 또는 null 값인 경우 익셉션 처리한다.
  - [ ] 문자열로 입력받은 계산식을 리스트 형식으로 변환한다.
- 문자열 계산식 목록 담당 객체 (`Expressions`)
  - [X] 완전한 계산식이 아닌 경우 익셉션 처리한다.
    - [X] 숫자와 연산자가 빈 칸 구분없이 연속으로 나오는 경우
    - [X] 연산식으로 끝나는 경우
    - [X] 빈 값으로 끝나는 경우
- 연산자 목록 담당 객체 (`Operation`)
  - [X] 입력 문자열의 사칙 연산을 계산한다.
  - [X] +, -, *, / 만 연산 처리한다.
  - [X] 0으로 나누면 익셉션 처리를 한다.
  - [X] 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 없는 경우 익셉션 처리한다.
  - [X] 지원하지 않는 연산자에 대해서 익셉션 처리한다.
  - [X] 사칙연산자가 아닌 경우 익셉션 처리한다.
  - [X] 입력 연산식이 빈 공간이 없는 경우 익셉션 처리한다.
- 연산 결과 담당 객체 (`CalculationResult`)
  - [X] 계산식의 결과를 구한다.

## Step1 : 2단계 - 로또(자동)

### 기능 요구사항

로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
로또 1장의 가격은 1000원이다

```text
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

### 기능 구현 진행사항

- [X] 로또 하나의 번호 역할을 담당하는 객체 : `Number`
  - [X] 로또 숫자는 1 ~ 45 사이 값이 아니면 익셉션 처리한다.
- [X] 로또 6개의 번호 역할을 담당하는 객체 : `LottonNumber`
  - [X] null 또는 빈 값일 경우 익셉션 처리한다.
  - [X] 입력받은 로또 번호를 생성한다.
- [X] 자동으로 생성되는 로또 역할을 담당하는 객체 : `AutoLottoNumbers`'
  - [X] 지동으로 생성한 로또 번호는 6자리이며 1보다 크거나 같고 45보다 작거나 같다.
  - [X] 구매 가능한 금액만큼 생성하며 자동 로또 번호 6자리를 생성한다.
  - [X] 자동 로또 출력시 로또번호는 오름차순으로 보여준다.
- [X] 1등 로또의 역할을 담당하는 객체 : `WinningLottoNumber`
  - [X] null 또는 빈 값일 경우 익셉션 처리한다.
  - [X] 1등 로또 번호를 5개만 입력 또는 7개 이상 입력하거나 중복된 숫자를 입력하면 익셉션 처리한다.
  - [X] 입력받은 값으로 1등 로또 번호를 생성한다.
  - [X] 1등 로또와 매칭하는 결과를 구한다.
- [X] 구매 금액의 따른 로또 구입 및 비율을 담당하는 객체 : `Purchase`
  - [X] 구매금액이 빈 값 또는 null인 경우 익셉션 처리한다.
  - [X] 로또 종이는 1000원 당 한장 구매 가능하다.
  - [X] 로또 구매 금액과 상금의 대한 비율을 구한다.
  - [X] 비율이 1.0 이하이면 정해진 메시지를 보여준다.
- [X] 각 등수의 우승상금 관리를 담당하는 객체 : `WinningPrize`
  - [X] 각 등수별 당첨금을 확인한다.
  - [X] 일치하는 번호가 2개 이하는 금액을 받지 못한다."
- [X] 당첨 결과 및 총 우승 금액 관리를 담당하는 객체 : `WinningResult`
  - [X] 총 상금을 구한다.
  - [X] 같은 등수가 2개인 우승 상금을 구한다.