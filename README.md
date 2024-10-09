# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈보다 먼저 계산해야하지만 이를 무시한다.
- 예를 들어 2 + 3 * 4 / 2 와 같은 문자열을 입력할 경우 2 + 3 * 4 /2 실행 결과인 10을 출력해야한다. 

## 프로그래밍 요구 사항
- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라 
- 메소드의 크기가 최대 10 라인을 넘지 않도록 구현한다. 
- method가 한 가지 일만 하도록 최대한 작게 만들어라


## 도메인 별 기능 구현 

### 계산 클래스
[✅] 더하기 기능 구현
[✅] 빼기 기능 구현
[✅] 곱하기 기능 구현
[✅] 나누셈 기능 구현
[✅] 정수로 떨어지는 값

### 숫자 파싱 클래스
[✅] 숫자 체크 기능 구현
[✅] 숫자 리스트 추가 로직 구현

### 연산자 파싱 클래스
[✅] 연산자 체크 및 파싱해주는 기능 구현
[✅] 연산자 리스트 추가 로직 구현

### Numbers 클래스
[✅] 첫 번째와 두 번째 숫자를 반환하고 리스트에서 제거 기능 구현
[✅] 새로운 숫자를 리스트 맨 앞에 추가 기능 구현

### Operators 클래스
[✅] 첫 번째 연산자를 반환하고, 리스트에서 제거 기능 구현
[✅] 연산자 리스트의 크기를 반환 기능 구현

## 문자열 유틸 클래스
[✅] 널 값, 빈 값 체크 기능 구현

### 입력 클래스
[✅] 사용자게에게 입력 받는 기능 구현
[✅] 문자열 split 기능 구현

### 결과 클래스
[✅] 사용자에게 연산 결과를 보여준다.