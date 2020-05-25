# 3단계 - 로또(2등)

## 기능 개발

- [X] 2등을 위해 추가 번호를 하나 더 추첨한다.
  - [X] InputView에 추가 번호 입력 기능 개발
  - [X] Lotto class에 hasBonus 개발
  - [X] LottoGame에서 BonusNumber를 입력받을 수 있는 setBonusNumber 개발
  - [X] LottoGame class에서 getLottoRank 개발 
- [X] 당첨 통계에 2등도 추가해야 한다.
  - [X] ResultView에서 2등에 대한 출력을 구분한다.
- [X] 당첨에 대한 메소드(Rank) 작성
  - [X] 기존의 WinningPrice를 Rank의 변경
  - [X] java enum을 적용해 프로그래밍을 구현한다.
  - [X] valueOf Method 개발: 파라미터에 대한 Rank를 구함 

## 기능 테스트

- [ ] Rank
  - [X] Rank valueOf Method Test 개발
- [ ] Lotto
- [ ] LottoGameLottoController