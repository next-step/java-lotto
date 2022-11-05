# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 🚀 1단계 - 문자열 계산기
### 기능 요구사항
* **사용자가 입력한 문자열 값**에 따라 **사칙연산을 수행할 수 있는 계산기**를 구현해야 한다.
* 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
* 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
* 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 
	* 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
	* 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### Hints
- 테스트할 수 있는 단위로 나누어 구현 목록을 만든다.
	- [x] 덧셈
	- [x] 뺄셈
	- [x] 곱셈
	- [x] 나눗셈
	- [x] 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
	- [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
	- [x] 사칙 연산을 모두 포함하는 기능 구현
- [x] 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
- 반복적인 패턴을 찾아 반복문으로 구현한다.

### TODO-list 
- Input Output Image
	- Intput : 2 + 3 * 4 / 2
	- Output : 10
	- Consideration :  
		- 입력 값에 따라 계산 순서가 결정
		- 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정
		- 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정
- Flow 
	- [x] Validate Input String
	- [x] Split String to String[]  by space
	- [x] Validate splitted strings
	- [x] 피연산자, 연산자용 Deque 초기화
		- [x] 각 String을, 피연산자, 연산자로구분하여, 각 큐에 addLast()
	- [x] Validate 연산 초기조건
		- 초기조건 : Number of 피연산자Deque >=2 and Number of 연산자 Deque >= 1
	- [x] Start 연산
		- 종료 조건 : Number of 피연산자Deque == 1 and Number of 연산자 Deque == 0
		- [x] 피연산자큐로부터, 원소 2개 pop()
		- [x] 연산자큐로부터, 연산자 1개 pop()
		- [x] 연산 수행하고 그 결과 값을 피 연산자큐에 addFirst
	- [x] 피연산자큐에서 마지막 원소를 pop()하여 반환.
### Note
- Try to use assertThatIllegalArgumentException()
- Q : How to check if given string is a numeric?
	- A : Just use Integer.parseInt(String)