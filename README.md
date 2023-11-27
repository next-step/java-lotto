# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

일반 사람이 로또를 로또 상점에서 구매한다.
가정은 한 사람이 일정 금액을 가지고 로또를 구매한다. 

### 🚀 **class 다이어그램 구성요소**
- lotto.LottoStore(판매자)
- 로또 발급 객체
- 로또 당첨자 선정 객체  -> Person
  

- Person(구매자)
- 로또 모음 일급 컬렉션 객체 -> Pocket
- 로또 일급 컬렉션 객체 -> lotto.Lotto 
- 로또 번호 객체 -> lotto.LottoNumber

- 사용자 input 받는 객체 -> InPutView
- 결과 OutPut을 뽑아내는 객체 -> OutPutView
### 🚀 **기능 정의**
- [x] 구매 개수에 따른 로또 발급 기능
  - [x] 6개의 숫자 발급
  - [x] 구매 금액만큼 로또 발급 기능
- [x] 로또 번호 제한 기능
- [x] 로또 중 당첨자 선정 기능
  - [x] 로또 번호 매칭 카운트 기능
  - [x] 로또 매칭 개수에 따른 카운트 기능
- [x] 수익률 계산 기능
- [x] 각 요소 프린트 기능

### 🚀 컴포넌트 조합 서비스 로직

- 구매 금액을 받는다. (from 사용자)
- 구매 금액에 따라 로또를 발급받는다.(로또 가격 1개 당 : 1000원)
- 지난 주 당첨 번호를 받는다.(from 사용자)
- 발급받은 로또들과 당첨 로또 번호를 비교한다.
    - 당첨 로또 번호와 일치하는 개수를 센다.