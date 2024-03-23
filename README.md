# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 목록
- 숫자를 추첨하는 NumberDrawer 인터페이스와 구현체 ShuffledNumberDrawer 구현
  - [X] 1 ~ 매개변수(숫자) 만큼의 숫자를 섞어서 앞에서부터 6개를 뽑아 정렬 후 반환
- 로또 하나를 가지는 LottoNumber 객체 생성
  - [X] 멤버 변수로 List\<Integer>를 가지는 일급 컬렉션
  - [X] LottoNumber를 매개변수로 받아 동일한 숫자를 필터링하여 개수를 반환하는 containsCount 구현
- 모든 로또를 가지는 LottoNumbers 객체 생성
  - [X] 멤버 변수로 List\<LottoNumber>를 가진다.
  - [X] 매개변수로 당첨 번호 리스트를 받아, LottoResult 객체를 반환
- 로또를 생성하는 LottoMachine 객체 생성
  - [X] 로또 개수와 NumberDrawer를 매개변수로 받아 LottoNumbers를 반환
- 당첨금 계산을 위한 LottoResult 생성
  - [X] 총 당첨금을 계산하여 반환 
  - [X] 매개변수로 당첨금과 로또 구매금액이 주어지면 수익률을 소숫점 이하 2자리로 반환
- 입력을 위한 InputView 객체 생성
  - [X] 로또 가격에 나누어 떨어지는 양수면서 정수인 값만 입력 받고, 1000을 나눠 로또의 개수를 반환하는 moneyInput() 구현
  - [X] 1 ~ BOUND 만큼의 양수면서 정수인 당첨 번호 6개를 입력받아 WinningNumbers 객체를 반환하는 winnnigNumbersInput() 구현
- 출력을 위한 OutputView 객체 생성
  - [X] 수익률을 출력
- [X] 로또를 진행하는 LottoGame 구현

## Todo
- [X] 보너스 볼 입력 받는 기능 구현
- [X] LottoRank에 2등 추가
- [X] 2등 출력 추가
- [X] LottoNumber의 Integer와 BonusNumber 합치기
- [X] 가능하면 추상화된 타입 참조하기 (EnumMap -> Map)
- [X] winning()에서 2등 계산 안되는 버그 수정
- [X] LottoResult.addCorrectLottoCount() 에서 Optional을 ifPresent로 처리
- [X] OutputView.printResult() 의 반복 print 리팩터링
- [X] 예외가 발생하지 않는 생성자 테스트를 assertThatNoException으로 리팩터링
- [X] LottoNumbersTest의 List.of()를 가변인자로 리팩터링
- [X] LottoNumber + bonusNumber 를 묶어서 WinningNumber
- [ ] 3단계 피드백 반영
  - [X] MyNumber, LottoNumber, LottoNumbers 클래스명 수정
  - [X] LottoResult의 winnings()를 correctCounts EntrySet을 사용하는 로직으로 리팩터링
  - [X] 보너스 넘버 검증 위치 수정
  - [ ] stream collect 와 return을 collectingAndThen 으로 리팩터링