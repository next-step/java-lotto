# 로또

## Step4 리팩토링 todo (테스트 코드 빠진 곳 추가 )

### Number

- [X] BonusNumber : 해당 없음
- [X] LottoNumber
- [X] LottoNumbers
- [X] RandomNumbers : 해당 없음
- [X] WinningNumbers

### ticket

- [ ] LottoTicket
- [ ] LottoTickets
- [ ] Prize
- [ ] TicketType

### GameResult

- [ ] Gain
- [ ] GameResult
- [ ] ProfitRate

### Game

- [ ] LottoGame
- [ ] Payments

## Step4 to-do

- [X] InputView
  - [X] 수동으로 구매할 로또 수를 입력해주세요.
  - [X] 수동으로 구매할 번호를 입력해 주세요. (로또 수만큼)
- [X] ResultView
  - [X] 수동으로 x장, 자동으로 y장 구입하셨습니다.
- [X] GameResult
  - [X] 수동 입력 추가
- [X] Helper 클래스 추가
  - [X] int[][]를 List<List<Intger>>로 변경
- [X] LottoTicket
  - [X] 타입 설정 (MANUAL, AUTO)
    - [X] 생성자에서 타입 설정하지 않을 경우 기본 값은 AUTO
- [X] LottoTickets
  - [x] 자동, 수동 카운트
## Step3 To-Do

- [X] InputView
  - [X] 보너스 번호 입력 받기
- [X] ResultView
  - [X] 당첨통계 내 2등 추가
- [X] 보너스 볼 추가
- [X] Prize 내 2등 추가

## step 2 To-Do

- [X] InputView
  - [X] 구입 금액 입력 받기
  - [X] 지난주 담청 번호 입력 받기


- [X] ResultView
  - [X] 구매 갯수 출력
  - [X] 로또 티켓 별 번호 출력
  - [X] 당첨 통계 추출
    - [X] 수익률 출력


- [X] LottoTickets(로또 티켓 리스트)
  - [X] 로또 티켓은 1장 이상이다.


- [X] LottoTicket(로또 티켓 단품)
  - [X] 로또 티켓은 당첨금을 리턴한다.


- [X] 랜덤 숫자 리스트
  - [X] 주어진 범위(숫자의 최댓값,최솟값,전체 숫자 개수)의 랜덤 리스트 자동 생성


- [X] 로또 숫자 리스트
  - [X] 로또 숫자 리스트의 길이는 6이다.
  - [X] 당첨 숫자 몇 개를 포함하는지 리턴


- [X] 로또 숫자
  - [X] 로또 숫자 범위는 1~45이다.
  - [X] 로또 숫자 1 미만 or 45 초과 일 경우 오류 출력

- [X] 당첨금
  - [X] 3개 일치시 5000원
  - [X] 4개 일치시 50000원
  - [X] 5개 일치시 1500000
  - [X] 6개 일치시 2000000000


- [X] 당첨 결과 예상
  - [X] 지난 주 당첨번호
  - [X] 각 등수에 해당하는 티켓의 숫자 도출
  - [X] 수익률
    - [X] 예상 상금 계산
    - [X] 수익률 계산 (소숫점 2번째 자리까지 계산 후 반올림)


- [X] 손익 판단 클래스
  - [X] 수익률 1미만: 손해
  - [X] 수익률 1: 본전
  - [X] 수익률 1 초과: 이득


- [X] 로또 게임 클래스
  - [X] 구입 금액
  - [X] 로또 금액 기반 갯수 계산


- [X] Helper 클래스 추가
  - [X] 테스트 데이터 생성용

## 로또 게임 룰 (참고용)
- [로또 번호는 1부터 45개까지 숫자 중 6개의 숫자 선택](https://www.google.com/search?q=%EB%A1%9C%EB%98%90+%EB%B2%88%ED%98%B8+%EB%B2%94%EC%9C%84&rlz=1C5CHFA_enKR946KR946&oq=%EB%A1%9C%EB%98%90+%EB%B2%88%ED%98%B8+%EB%B2%94%EC%9C%84&aqs=chrome..69i57.2376j0j4&sourceid=chrome&ie=UTF-8)


    