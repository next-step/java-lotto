# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 기능
1. 구입금액을 입력 받는다. INPUT
2. 유저에 구입금액을 저장한다 USER
3. 구입금액, 로또 가격으로 수량을 계산한다 CALCULATOR
+ 로또를 생성한다 GENERATOR
4. 수량만큼 로또를 생성한다 GENERATOR
5. 유저에 로또를 저장한다 USER
6. 당첨 번호를 입력 받는다 INPUT
7. 유저의 로또 목록과 당첨번호를 비교 한다 WINNING_NUMBER
8. 로또에 일치 갯수를 저장한다. LOTTO
9. 로또목록으로 수익금을 계산한다. ProfitCalculator

### step4
1. Calculator - 금액, 수동 로또 수량 입력 받아서 자동 로또 수량 리턴
2. InputView - 수동 로또 수량만큼 입력 받아서 List<Integer> 리턴
3. Generator - 수동 로또 List<Integer> 로 List<LottoTicket> 생성, 리턴
4. ResultView - 수동 로또 수량, 자동 로또 수량 출력
5. Generator - 자동으로 생성한 List<LottoTicket>에 수동으로 생성한 List<LottoTicket> 추가 