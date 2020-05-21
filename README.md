# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)



## 문자열 덧셈 계산기

### 기능 목록

- String 형태의 숫자를 정수로 바꾸고 유효성 검사도 하는 Number 클래스
- Number 리스트를 관리하는 ExpressionNumbers 클래스
- 입력받은 Text를 구분자에 따라 split 하는 Splitter 클래스
- 입력받은 Text를 계산하는 StringAddCalculator 클래스


## 로또

### 기능 목록

- 로또 번호 하나를 가지는 LottoNumber 클래스
- 6개의 LottoNumber 를 관리하는 일급 컬렉션 LottoTicket
- 금액에 맞춰 LottoTicket 을 발급하는 LottoMachine
- 로또를 추첨하는 추첨기 Drawing Machine
- 로또 당첨 통계 정보를 가지고 있는 Enum WinningStatistics