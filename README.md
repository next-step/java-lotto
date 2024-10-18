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


---
## 로또 구현

## 프로그래밍 요구사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 쓰지 않는다.
- 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.


## 도메인 별 기능 구현

### LottoGenerate 클래스
[✅]로또 랜덤으로 뽑는 메서드 로직 구현

## Money
[✅] 돈으로 살 수 있는 총 티켓 개수 구하는 로직

## PassivityLottoCount
[✅] 수동 로또 개수 구하는 로직 
[✅] 자동 로또 개수 구하는 로직
[✅] 수동으로 몇개 살 수 있는지 Validate 로직

## Purchase
[✅] 돈이 부족한 경우 validate 구현 로직
[✅] 받은 금액 1000원으로 나누는 구현 로직
[✅] 로또 금액으로 금액에 맞는 로또 개수 구매 로직 
[✅] 수동 로또 개수 확인 로직
[✅] 수동으로 구매한 로또 추가하는 로직

## LottoTicket
[✅] 몇개 맞았는지 반환하는 로직
[✅] 보너스 넘버 확인 로직

## LottoTickets
[✅] 티켓 여러개 추가 로직
[✅] 몇개 맞았는지 리스트롤 반환하는 로직

## Lotto
[✅] 지난주 로또 번호 저장 로직
[✅] 몇 개 맞았는지 저장

## Statistics
[✅] 등수별로 맞은 로또 번호의 개수를 리스트로 반환하는 로직
[✅] 각 등수별로 맞은 로또 번호의 개수를 모두 더한 총합을 리스트로 반환 로직
[✅] 구매한 로또 수와 총 당첨금액을 기반으로 수익률을 계산하여 소수점 두 자리까지 반환 로직
[✅] 각 등수별 맞은 개수와 당첨 상금을 계산하여 리스트로 반환 로직
[✅] 주어진 리스트에 있는 상금의 총합을 계산하여 반환 로직
[✅] 구매한 로또 수에 대한 상금 총합의 비율(수익률)을 계산하여 반환 로직


## InputView 도메인 클래스
[✅] 사용자로부터 구입 금액을 입력
[✅]  사용자로부터 지난 주 당첨 번호를 입력
[✅] 사용자로부터 로또 번호 수동으로 받는 로직 추가

## ResultView 도메인 클래스 
[✅] 구매한 로또 티켓들의 번호를 출력
[✅] 구매한 로또 개수를 출력
[✅] 수익률을 출력
[✅] 각 등수별로 당첨된 로또 개수를 출력

