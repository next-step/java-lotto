# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

# 1단계 - 문자열 계산기
## 기능 목록
- [x] 입력 값이 null이거나 빈 공백 문자일 경우, IllegalArgumentException throw
- [x] 사칙연산 기호가 아닌 경우, IllegalArgumentException throw
- [x] 피연산자를 시작으로 연산자와 피연산자가 번갈아 입력되어야 하고, 마지막은 피연산자로 끝나야 한다.
- [x] 피연산자의 갯수는 연산자의 갯수보다 하나 많다.
- [x] 나눗셈의 경우, 결과 값을 정수로 떨어지는 값으로 한정
- [x] 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정

--- 

# 2단계 - 로또(자동)
## 기능 목록
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또 발급
  > 로또 한장의 가격은 1,000원  
  > 로또 한장 당 자동으로 1에서 45의 숫자 중 6개 번호를 선택
- [x] 자동으로 선택된 숫자는 오름차순으로 정렬하여 출력
- [x] 천원 미만의 금액 입력 시, 예외 발생
- [x] 지난 주 당첨 번호를 csv 형태로 입력
- [x] 당첨 번호가 양의 정수가 아닐 경우 예외 발생 
- [x] 구매한 로또에 대한 당첨 통계 콘솔 출력
  > 3개 일치: 5,000원  
  > 4개 일치: 50,000원  
  > 5개 일치: 1,500,000원  
  > 6개 일치: 2,000,000,000원
- [x] 구입 금액 대비 당첨 금액에 대한 수익률 계산
  > ex) 14,000원치 로또 구입 후 5,000원 당첨이면, 수익률은 0.35(5,000/14,000)

---

# 3단계 - 로또(2등)
## 변경 사항
- 로또 구매 포장 클래스 신규: `LottoPurchase`
  > 금액 검증 수행  
  > `LottoSeller` 객체는 `LottoPurchase` 객체를 활용해 `Lottos` 객체 생성
- LottoNumber 캐싱 방식 변경: `inner class` → `Map`
- 로또 결과 확인 시, 상금이 없는 경우는 `NOT_WIN`로 일원화
  > `MATCH_ONE_NUMBER`, `MATCH_TWO_NUMBER` 삭제
- `RandomLottoNumbersFactory` 내 매직넘버 삭제
- 하나의 단위 테스트 내 여러 `assert` 메소드가 있는 경우, `assertSoftly` 적용
  > `LottoResultsTest`

## 기능 목록
- [x] 보너스 번호 추가
  > 5개 일치 + 보너스 볼 일치(2등) 시, 당첨 금액은 30,000,000원  
  > 로또 결과를 확인의 책임 변경: `WinningLotto` → `WinningLottoWithBonus`
- [x] 지난 주 당첨 번호 입력 후 보너스 볼 입력
  > 보너스 번호가 당첨 번호에 있을 시, 예외 발생
- [x] 당첨 통계에 2등도 추가