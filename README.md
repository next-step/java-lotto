# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 - 문자열 덧셈 계산기

### 요구사항

- 쉼표 또는 콜론을 구분자로, 문자열의 합을 반환
- 커스텀 구분자 지점 가능
  - 커스텀 구분자는 \\(.+)\n 를 사용한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하면 RuntimeException

- depth 1단계
- 메소드 10라인 이하
- else 사용 x

### 기능 구현 목록

- [x] 쉼표가 구분자일 때 덧셈 결과 값을 반환한다.
- [x] 콜론이 구분자일 때 덧셈 결과 값을 반환한다.
- [x] 커스텀 구분자를 추출한다
- [x] 커스텀 구분자로 덧셈 결과 값을 반환한다.
- [x] 음수나 숫자가 아니면 RuntimeExceiption을 반환한다.

## 2단계 - 로또(자동)

### 기능 구현 목록

- [x] 로또 한 게임 생성 : 1~45 사이의 6개의 숫자를 랜덤으로 생성한다. 
- [x] 입력받은 금액만큼 로또 게임을 생성한다.
- [x] 한 로또 게임과 당첨 번호를 비교해 몇 개가 일치하는지 구한다.
- [x] 다수의 로또 게임과 당첨 번호를 비교해 3개 이상 6개 이하 일치하는 횟수를 구한다.
- [x] 수익률을 구한다.

### 객체 모델링

#### LottoGame

- LottoNumbers를 여러개 가짐
- LottoWinningNumbers를 가짐
- WinningInfos(결과 통계값)을 계산한다
- 수익률을 계산한다.

#### LottoMoney

- 사용자가 입력한 금액 값을 가짐
- 금액값이 1000원 이상인지 검사한다.

#### LottoNumberPublisher

- 1~45 사이의 랜덤한 숫자를 제공

#### LottoNumbers

- 사용자가 입력한 숫자(Number)를 여러개 가진다.

#### LottoWinningMoney

- 당청금 값을 가짐
- 곱셉한 값 제공

#### LottoWinningNumbers

- 당첨 번호를 가짐
- LottoNumbers를 받아 당첨 타입(LottoWinningType) 제공

#### LottoWinningType

- 당첨 타입

#### Number

- 로또에서 사용하는 하나의 숫자를 담은 객체
- 1~45 범위의 숫자를 가진다.

#### WinningInfo

- LottoWinningType과 당첨된 횟수를 저장 

#### WinningInfos

- WinningInfo를 여러개 저장
- getTotalWinningMoney : 총 당첨 금액을 제공
