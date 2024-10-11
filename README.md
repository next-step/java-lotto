# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Step1. 요구사항
* 입력값이 null, 빈 공백일 경우 익셉션 발생
* 빈 공백 문자열 분리
* 숫자가 올바르지 않은 경우 익셉션 발생
* 연산기호가 올바르지 않은 경우 익셉션 발생
* 덧셈 구현
* 뺄셈 구현
* 곱셈 구현
* 나눗셈 구현

## Step1. 피드백 구현
* enum 안에서 람다식으로 함수 구현 가능
* enum 클래스 안에 있는 method 별도로 꺼내지 않고 enum 클래스 이용
* operatorClass -> operatorMethod 네이밍 변경
* parameterizedTest 적용
* validate 로직 내부로 이동
* queue에 넣을 때 string이 아닌 enum 클래스 삽입 (변경 안해도 됨)
* SPACE -> DELIMITER 네이밍 변경
* 유효성 체크 로직 이동 (queue에서 꺼낼 때 체크)
* public 한정자 제거

## Step2. 요구 사항
* 입력 개수만큼 셔플해 로또 하나를 추첨한다. (입력 개수가 바뀔 수 있으므로)
* 구매한 개수만큼 로또를 추첨한다.
* 로또를 비교해 일치하는 개수를 추출한다.
* 최종 당첨금액과 구입금액을 비교해 수익률을 계산한다.

## Step2. 피드백 구현
* Arrays.asList() -> List.of() 변경 (Arrays.asList는 값 변경 가능, null 허용)
* 로또 sort 로직 이동 (로또 번호 추출부)
* ParameterizedTest로 중복 테스트 제거
* 중복 테스트 제거 (isEqualTo로 했으면 size 비교는 중복)
* controller에서 금액 삭제
* parsing 로직 view로 이동


## Step2. 리팩토링 내용
* 패키지 이동 (controller, ui 를 lotto 도메인 내부로 이동)
* 로또 유효성 검사로직 추가 (6개, 1~45)
* 상수 클래스 분리