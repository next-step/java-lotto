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
  - [ ] 숫자 리스트를 매개변수로 받아 동일한 숫자를 필터링하여 개수를 반환하는 containsCount 구현
- 모든 로또를 가지는 LottoNumbers 객체 생성
  - [ ] 멤버 변수로 List\<LottoNumber>를 가진다.
  - [ ] 매개변수로 당첨 번호 리스트를 받아, LottoResult 객체를 반환
- 로또를 생성하는 LottoMachine 객체 생성
  - [ ] 로또 개수와 NumberDrawer를 매개변수로 받아 LottoNumbers를 반환
- 수익률 계산을 위한 ReturnCalculator 생성
  - [ ] Result를 매개변수로 받아, 총 당첨금을 계산하여 반환 
  - [ ] 매개변수로 당첨금과 로또 구매금액이 주어지면 수익률을 소숫점 이하 2자리로 반환
- 입력을 위한 InputView 객체 생성
  - [ ] 로또 가격을 매개변수로 받아 나누어 떨어지는 양수면서 정수인 값만 입력 받고, 1000을 나눠 로또의 개수를 반환하는 moneyInput() 구현
  - [ ] 1 ~ BOUND 만큼의 양수면서 정수인 당첨 번호 6개를 입력받아 WinningNumbers 객체를 반환하는 winnnigNumbersInput() 구현
- 출력을 위한 OutputView 객체 생성
  - [ ] LottoResult가 주어지면 3개, 4개, 5개, 6개 각각 일치하는 개수를 출력하고 ReturnCalculator로 계산된 수익률을 출력
