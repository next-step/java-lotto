# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## TO DO LIST(Step1)
- [x] 테스트 코드 작성
- [x] 입력 뷰 클래스 구현
- [x] 원시 값 wrapper 클래스 구현
- [x] 연산자 클래스 구현
- [x] 문자열 계산기 구현

## TO DO LIST(Step2)
- [x] 테스트 코드 작성
- [x] Money 클래스 구현
- [x] 로또 숫자 클래스 구현
- [x] 로또 클래스 구현
- [x] 로또 저장 클래스 구현
- [x] 로또 상점 클래스 구현
- [x] 입력 뷰 클래스 구현
- [x] 출력 뷰 클래스 구현

## TO DO LIST(Step3)
- [x] WinningInformation 수정
  - [x] 2등 추가
  - [x] 보너스 볼 포함 여부 추가
  - [x] findByCountOfMatchedNumber 수정
- [x] MatchingResult 생성
  - [x] Lotto.matchWithWinningLotto 수정
  - [x] WinningInformation 필드 타입을 MatchingResult로 수정
- [x] LottoStorage.matchAllWithWinningLotto 수정
- [x] InputView 에 추가 번호를 입력할 수 있도록 수정
  - [x] Lotto에 contains 메소드 추가

## TO DO LIST(Step4)
- [x] InputView 수정
  - [x] 수동으로 구매할 로또 수 입력 메소드 추가
  - [x] 수동으로 구매할 로또 번호 입력 메소드 추가
- [x] 수동 로또 전략 클래스 추가
  - [x] 수동 구매 로또 수와 수동 구매 로또 세트 수를 비교하는 검증 메소드 추가
- [x] Money.take 메소드 추가
- [x] LottoStorage 수정
  - [x] 기본 생성자 추가
  - [x] add 메소드 추가
- [x] LottoStore 수정
  - [x] buyLotto 메소드 파라미터로 LottoStorage를 받도록 수정
  - [x] buyLotto 메소드 반환 타입을 void로 수정