# 로또
## 요구 사항 분석

### Domain
* LottoService (* 추가 생각)
  - [x] field : Payment
  - [x] field : Lottos
  - [x] action : 당첨 통계 계산
  - [x] action : 수익률 계산
  - [x] action : 로또 번호 6자리 생성
* Payment -> type : int
  - [x] validation : 내가 투입한 금액이 1,000원 미만 인지?
  - [x] action : 몇 장만 산다?
  - [x] 로또 구입 갯수 계산 (개당 1,000원)
* Lottos -> 일급 컬렉션, type : List<Lotto>
  - [x] action : 당첨 통계 계산
* WinningNumber
  - [x] field : Lotto
  - [x] filed : LottoNumber
  - [x] validation : 로또넘버 안에 보너스 볼과 일치하는 숫자가 있는지 검증
* Lotto -> 일급 컬렉션, type : List<Number>
  - [x] validation : 중복이 있는 지
  - [x] validation : 6개의 숫자인지
  - [x] action : 일치하는 숫자 카운트
* LottoNumber -> type : int
  - [x] validation : 1~45의 숫자
* LottoText -> type : List<Integer>
  - [x] validation : 빈 값인지 확인
  - [x] validation : 숫자인지
  - [x] action : 파싱된 숫자 리스트 반환

### View
* [x] 구입금액 - 입력
* [x] 당첨번호 - 입력
* [x] 보너스볼 - 입력
* [x] 로또 구매 개수 - 출력
* [x] 자동 로또 번호 출력 - 출력
* [x] 당첨통계 출력 - 출력
* [x] 수익률 출력 - 출력

### View - 담첨 통계
* 3개 일치 (5000원)- ~ 개 
* 4개 일치 (50000원)- ~ 개
* 5개 일치 (1500000원)- ~ 개 
* 5개 일치, 보너스 볼 일치(30000000원) - ~ 개 
* 6개 일치 (2000000000원)- ~ 개
* 총 수익률 = (당첨 금액) / 투입 금액
  * 3째 자리에서 round up

----
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
