# 문자열 사칙 연산 계산기

## 기능 요구사항

* 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
* 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
* 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
* 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
* 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 기능 요구사항 정리 
* 문자열을 입력받는 View 생성
  * [ ] 공백 문자열로 구분
  * [ ] 숫자와 연산자로 분리해서 반환
  * [ ] 나눗셈의 경우 분모로 0을 받을 수 없음
* 계산 수행 객체
  * [ ] 숫자 2개와 연산자하나를 통해 계산
  * [ ] 연산자별로 다른 계산방식을 가짐
* [ ] 계산 결과 출력
  