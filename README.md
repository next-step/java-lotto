# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


---


### 문자열 계산기 기능 목록
#### UI
- [x] 입력값 받기 
  - [x] null이거나 빈 공백인 경우 IllegalArgumentException throw
  - [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- [x] 연산 결과값 출력하기

#### 계산기
- [x] 덧셈
- [x] 뺄셈
- [x] 곱셈
- [x] 나눗셈
  - [x] number2는 0보다 커야한다.

---

### 로또 기능 목록
#### UI
- [x] 구입금액 입력
- [x] 지난주 당첨번호 입력
  - [x] 번호 갯수 6개가 아닌 경우 IllegalArgumentException throw
  - [x] 중복번호가 있는 경우 IllegalArgumentException throw
  - [x] 숫자가 1 ~ 45가 아닌 경우 IllegalArgumentException throw
- [x] 보너스 볼 입력
  - [x] 이미 입력한 지난주 당첨번호에 포함되는 숫자인 경우 IllegalArgumentException throw
  - [x] 숫자가 1 ~ 45가 아닌 경우 IllegalArgumentException throw
- [x] 구매한 개수 출력
- [x] 구매한 로또 목록 출력
- [x] 당첨 통계 출력
  - [x] 2등 추가 (5개 일치, 보너스 번호 일치)
- [x] 총 수익률 출력

#### 로또
- [x] 구입금액에 맞게 로또 구매
  - [x] 로또 금액보다 적은 금액일 때 IllegalArgumentException throw
- [x] 로또 번호 자동 생성
- [x] 한 개의 로또에 일치하는 개수 확인
- [x] 당첨된 로또 개수 확인 (3, 4, 5, 6개 일치)
  - [x] 보너스 볼 일치 확인
- [x] 수익률 계산
