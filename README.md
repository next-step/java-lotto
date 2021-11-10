# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 문자열 덧셈 계산기
## 기능 목록
- StringAddCalculator
    - 입력 값이 구분자를 통해 정상적으로 들어오면 덧셈해서 리턴한다.
    - 입력 값이 null 이나 비어있는 값이 오면 0를 리턴한다.
- UserInput      
    - 입력 값이 null 이나 비어있는 값이 오면 false를 리턴한다.
- StringSplitter
  - \\ \n 사이에 들어오는 구분자를 Delimiter로 리턴한다.
  - 실제로 add되어야 할 Items 를 반환한다.
- Delimiter  
    - 기본 구분자는 ':' ',' 둘다 지원한다.
    - \\ \n 사이에 들어오는 구분자도 지원한다.
    - Delimiter의 Symbol 값 존재 여부를 검증한다.
- Items
    - sum() 호출시 모든 값을 더해서 반환한다.
- Item
    - 음수 값 / 문자열이 있을 경우 Runtime Exception을 발생시킨다.
    - add() 인자로 들어온 값과 지금의 값을 합쳐서 합계를 반환한다.

# 로또 step 2 - 자동
## 기능목록
- LottoRule
  - 로또의 범위를 가진 룰을 생성한다
  - 1-45의 6개의 숫자
  - 로또 한장의 금액
- LottoNumber
    - 생성 시 숫자가 아닌 값이 오면  Runtime Exception
    - 숫자의 범위가 1-45가 아니면  Runtime Exception
- Lotto
    - 생성 시 LottoNumber의 배열이 6자리가 아니면 runtime exception
    - checkWinning() 비교 후 일치하는 숫자의 WinningRank를 반환
    - LottoNumber 배열 sort()
- Lottos
    - Lotto list를 래핑하는 1급객체
- 당첨 enum
    - 등수 / 일치 개수 / 상금 을 밸류로 가짐
- LottoWallet
    - 수익률 구하기
    - 로또 당첨 확인
- Money
  - 생성 시 숫자가 아닌 값이 오면  Runtime Exception
  - 금액을 기준으로 살 수 있는 로또 갯수를 구함
  - 금액 비교 lessThan 생성
- LottoSeller
  - buyLotto(Money) 살 수 있는 만큼의 Lotto를 생성해서 반환
  - money 가 price 보다 작을 경우 Runtime Exception
  - money 가 null 일 경우 Runtime Exception
- LottoGenerator
  - 로또 갯수 만큼 생성
- LottoGeneratorStrategy
  - functional interface로 구현 -> 이후 테스트 시에 특정 값을 쉽게 입력할 수 있게
  - generate() 
  - RandomLottoGeneratorStrategy 랜덤으로 발생
- WinningHistory
   - 로또 당첨 내역 VO
   - 가지고 있던 money
   - 당첨 Money
- InputView 구현
   - 유저 입력
- OutputView 구현
   - WinningHistory 를 통해 당첨내역 출력
  
