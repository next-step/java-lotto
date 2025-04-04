# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능목록
### 뮨자열 계산기
- [x] 입력값을 공백을 기준으로 토큰을 분리
- [x] 분리된 토큰에서 '숫자'와 '사칙연산 부호'을 분리
- [x] 순서대로 계산
  - [x] 덧셈 계산기
  - [x] 뺄셈 계산기
  - [x] 곱셈 계산기
  - [x] 나눗셈 계산기
- [x] 입력값이 null or blank일 때 IllegalArgumentException throw
- [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw

### 로또(자동)
- [x] 구입 금액 입력 받기
- [x] 구입 금액에 따라서 로또 구매 개수 구하기
- [x] 로또 발급
- [x] 발급 결과 출력
- [x] 지난 주 당첨 번호 입력 받기
- [x] 당첨 여부 판별 하기
- [x] 당첨 통계 출력
- PR 피드백 반영
  - [x] Const 클래스 대신 Enum 활용
  - [x] List<Lotto> Lottos라는 일급컬렉션으로 만들기
  - [x] int array 대신에 List으로 바꾸기
  - [x] 당첨결과에 대한 DTO 만들어서 적용하기
  - [x] Lotto 불변객체로 만들기(numbers 외부에서 접근 못하게 하기)
  - [x] 구입금액 입력 검증 로직 추가
  - [x] 당첨번호 입력 검증 로직 추가
  - [] NUMBER_SIZE 상수 추출
  - [x] SALES_PRICE 상수 이용
  - [] List Set 변환으로 개수 체크
  - [] Enum valueOf stream 활용
  - [] LottoNumber에 validation 책임 위임
