# 로또(자동)

## 기능 구현 목록
- 로또 구입 금액을 입력
  - 로또 구입 금액 정상 확인 (1000단위 잔액 없는지 확인)
  - 로또 1장의 가격은 1000원
- 로또 게임횟수 출력
- 게임횟수만큼 생성된 로또 번호 출력
- 지난주 당첨번호 입력
  - 정상 확인
- 당첨번호와 생성 로또 번호 비교해서 맞힌 횟수 저장
- 일치 횟수가 3 이상이 경우 출력
  - 3 이상인 경우 상금 저장
- 총 수익률 (총 구매금액-당첨금)/구매금액 출력


## 구현목록
- LottoApplication
  - main() : 메인 method

- LottoGame
  - int buyRound : 구매 횟수
  - int getBuyRound() : 구매 횟수 리턴
  - Lottos start() : 구매 횟수만큼 로또 게임 리스트 리턴

- LottoNumber
  - int number : 로또번호
  - int getNumber() : 로또번호 리턴

- Lotto
  - set<LottoNumber> lottoNumbers : 로또번호 집합

- Lottos
  - List<Lotto> lottos : 일급 컬렉션 (LottoGame)

- Rank
  - int countOfMatch : 맞힌 횟수
  - int winningMoney : 우승 상금
  - int getCountOfMatch() : 맞힌 횟수 리턴
  - int getWinningMoney() : 우승 상금 리턴

- InputView
  - requestPurchaseAmount() : 구매금액 입력
  - requestLastWeekWinningNumber() : 당첨 번호 입력

- ResultView
  - responseLottoCount() : 로또 생성 횟수 출력
  - responseLottoNumbers() : 자동 로또 번호 출력
  - responseWinningStatistics() : 당첨 통계 출력
  - responseWinningRate() : 당첨 수익률 출력

## 추후 개발 사항
- dto
- 예외 처리