# 기능 구현 목록

## step1
### 도메인
- [x] 두 숫자의 사칙연산
  - [x] 덧셈
  - [x] 뺄셈
  - [x] 곱셈
  - [x] 나눗셈
- [x] 여러 숫자의 사칙연산
  - [x] 여러 숫자의 사칙연산 실행결과 확인
  - [x] 예외 처리
    - [x] 나눗셈의 경우 결과 값이 정수로 떨어지는 값이어야 한다.
    - [x] 사칙연산 기호가 아닌 경우 예외 던지기.
    - [x] 숫자와 연산 기호 사이에 공백이 없는 경우 예외 던지기.
    - [x] null 및 "" 입력 시 예외 던지기.
    - [x] 숫자나 기호를 연속으로 입력한 경우 예외 던지기.
    - [x] 공백 하나 또는 기호 하나만 넣는 경우 예외 던지기.
- [x] 숫자 하나만 입력 시 그대로 반환


## step2
### 입력
- [x] 로또 구입 금액을 입력 받는다.
  - [x] 로또 구입 금액 입력 값 반환
  - [x] 예외 처리
    - [x] null, "" 입력 시
    - [x] 숫자가 아닌 값 입력 시
    - [x] 입력 값이 1000원 단위가 아닐 시
    - [x] 0원 입력 시
    - [x] 음수 입력 시
- [ ] 지난 주 당첨 번호 입력 받기.
  - [x] 지난 주 당첨 번호 입력 값 반환
  - [ ] 예외처리
    - [x] null, "" 입력 시
    - [x] 콤마 구분자가 아닌 경우
    - [x] 숫자가 아닌 값 입력 시
    - [x] 음수 입력 시
    - [ ] 입력 형식에 맞지 않는 경우

### 출력
- [ ] 자동으로 발급 받은 로또 번호 출력하기.
- [ ] 당첨 통계 출력하기.
- [ ] 총 수익률 출력하기.


### 도메인
- [x] (입력 받은 값 / 1000) 장 만큼 자동으로 로또 발급하기.
- [x] 지난 주 당첨 번호와 비교하여 몇 개 일치하는지 계산하기.
  - [x] 3개 일치 개수
  - [x] 4개 일치 개수
  - [x] 5개 일치 개수
  - [x] 6개 일치 개수
- [x] 총 수익률 계산하기.
  - [x] 일치 번호 개수 리스트 반환하기.
- [x] 번호 일치 개수 당 당첨 횟수 구하기.



================== 실제 동작 모습 ==================

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
