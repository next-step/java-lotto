# 1단계 - 문자열 덧셈 계산기

## 요구사항

### 기능 요구사항

* Delimiter
  - [ ] 입력받은 문자열의 피연산자를 분리하기 위한 구분자 정의
    - [x] default 구분자
    - [x] custom 구분자  
* Separator
  - [ ] 문자열 분리
  - [x] 커스텀 구분자로 분리
* StringAddCalculator
  - [x] null 혹은 빈 문자열 확인
  - [x] 피연산자의 int 값으로 연산
  - [ ] 피연산자의 조건 : 양수 (음수, 문자 등의 경우 RuntimeException throw)

### 프로그래밍 요구사항

- indent는 depth를 2를 넘지 않도록 구현
  - 힌트: indent depth를 줄이는 좋은 방법은 메소드를 분리!
- 메소드 길이 < 10라인
  - 메소드가 한 가지 일만 잘 하도록 구현
- else 예약어를 쓰지 말 것 (switch/case 또한 허용하지 않음)

