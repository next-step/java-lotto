# 문자열계산기

1. 입력
2. 문자 split
3. 사칙연산
4. 총 수식 계산
5. 출력
6. 입력값 공백 검증
7. 연산자 사칙연산 검증

# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

로또 기능

1. 금액 입력

- InputView buyLotto()

2. 입력된 금액으로 로또 구매 갯수 출력 v

- ResultView printLottoTickets()

3. 1 ~ 45 중 무작위로 로또 번호 생성 v

- LottoService createTickets()

4. 당첨번호 입력 v

- InputView checkWinning()

5. 당첨여부 구하기 v

- LottoStatisService compareWithWinningNumbers()

7. 구매로또번호 출력 V

- ResultView printLottoTickets()

8. 지난주 당첨 번호 입력

- InputView checkWinning()

9. 3개 이상 당첨된 로또 통계

- LottoTickets tallyUp()

10. 총 수익률 구하기

-LottoTickets getTotalReturn()

11. 당첨결과 출력

-ResultView printWiningResult()