# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 요구 사항(기능 목록) 정리
## Step 2 - 로또(자동)
### View
- [X] 구매 금액 입력
- [X] 지난 주 당첨 번호 입력
- [X] 일치 개수 출력
- [X] 총 수익률 출력
### Domain
- [X] 입력된 금액에 따라 로또 구매 개수 결정
- [X] 로또 번호 자동 생성
- [X] 각 로또가 지난 주 당첨 번호와 일치 되는 값이 몇 개인지 계산
- [X] 일치 개수에 따라 당첨금 계산
- [X] 총 당첨금과 구매 금액에 따라 수익률이 어떻게 되는지 계산

## Step 3 - 로또 2등
### View
- [X] 당첨 통계 출력에 2등 출력 추가
### Domain
- [X] 보너스 볼 추첨 기능 추가
### Refactoring 목록
- [X] Lotto의 원시 데이터를 LottoNumber 클래스로 wrapping하기
- [X] winningNums 배열을 Lotto 클래스로 wrapping하기
- [X] WinningLotto 클래스로 winningNums와 bonusNumber를 wrapping하기
  - [X] matching 값을 세는 로직을 WinningLotto로 이동 시키기
- [X] 세부 클래스에서 구현된 세부 기능들도 Test로 구현하기
- [X] Prize.valueOf를 사용할 때 try-catch문을 사용하지 않도록 변경

## Step 4 - 로또 수동
### View
- [ ] 수동으로 구매할 로또 수 입력 기능 추가
- [ ] 수동으로 구매할 로또의 번호 입력 기능 추가
- [ ] 자동 생성 로또들의 번호, 수동 생성 로또 들의 번호를 함께 출력하는 기능 추가
### Domain
- [ ] Lotto 번호 Generate할 때 입력된 수동 구매 로또 수 만큼 입력된 번호로 로또 생성하는 기능 추가
  - [ ] 자동, 수동으로 구매할 Lotto 개수 저장
- [ ] 수동 구매 개수를 제외한 나머지 개수만큼 수동으로 로또 생성하는 기능 추가
### Refactoring 목록
- [X] View에서 전달인자를 인스턴스 자체를 받는게 아니라 View를 그리기 위해 필요한 필드만 전달 받도록 수정하기
- [X] Prize valueOf에서 불필요한 if문 제거해보기
- [X] LottoNumber의 Collection을 List로 변경
- [X] Lotto 클래스의 컬렉션을 List에서 Set으로 변경