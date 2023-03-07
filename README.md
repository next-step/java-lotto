# 문자열 덧셈 계산기

## 요구사항

1. 문자열 체크 : 빈 값 또는 공백 여부 체크.
2. 구분자 체크 : 기본 구분자인지, 커스텀 구분자인지 체크하여 구분자를 리턴.
3. 피연산자 파싱 : 구분자 체크에서 리턴된 구분자로 입력된 문자열 분리 후, 리스트로 리턴.
4. 계산 : 피연산자 리스트를 가지고 덧셈 계산.

## 객체

- Operand
  - [x] 연산자
  - [x] 생성자
  - [x] 연산자 값 체크 함수
  - [ ] 연산자 분리 함수

- Seperator
  - [x] 기본 분리자 상수
  - [x] 구분자 변수
  - [x] 구분자 제외 값 변수
  - [x] 입력값 빈 값 및 공백 체크 함수
  - [x] 구분자 종류 체크하는 함수
  - [ ] 연산자 분리 함수

- Operands
  - [ ] 리스트 피연산자 변수
  - [ ] 문자열 분리 (원래문자열, 구분자)

- Calculator
  - [x] 덧셈 함수
