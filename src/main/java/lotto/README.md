# 문자열 덧셈 계산기

## 기능 구현 목록
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.


## 구현목록
- LottoApplication
  - main() : 메인 method
  

- LottoNumber
  - int[] numbers : int 문자열
- LottoNumbers
  - List<LottoNumber> LottoNumbers : 일급 컬렉션 (LottoNumber)
  

- InputView
  - requestPurchaseAmount() : 구매금액 입력
  - requestLastWeekWinningNumber() : 당첨 번호 입력
- ResultView
  - responseLottoCount() : 로또 생성 횟수 출력
  - responseLottoNumbers() : 자동 로또 번호 출력
  - responseWinningStatistics() : 당첨 통계 출력