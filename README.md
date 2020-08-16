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

### 초기 기능 구현 목록

- [x] 로또 한 게임 생성 : 1~45 사이의 6개의 숫자를 랜덤으로 생성한다. 
- [x] 입력받은 금액만큼 로또 게임을 생성한다.
- [x] 한 로또 게임과 당첨 번호를 비교해 몇 개가 일치하는지 구한다.
- [x] 다수의 로또 게임과 당첨 번호를 비교해 3개 이상 6개 이하 일치하는 횟수를 구한다.
- [x] 수익률을 구한다.

### 객체 모델링(리팩토링 후)

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

## 3단계 - 로또(2등)

- 2등을 위해 추가번호를 하나 더 추첨한다

### 기능 정의

- 구입 금액에 해당하는 로또 게임을 발급한다.
- 당첨 번호에 따라 당첨 통계를 제공한다.
- 수익률을 계산한다.
 
### 객체 모델링

#### Number

- 로또 게임에서 사용하는 하나의 숫자를 가진다.
- [x] number가 1 ~ 45 사이의 값을 가지지 않으면 예외를 반환한다.

#### LottoNumbers

- Number를 6개 가진다.
- [x] 번호(Number)가 6개의 다른 값이 아니면 예외를 반환한다.
- [x] 자신이 가진 로또 번호와 제공된 로또 번호에서 일치하는 번호 리스트를 제공한다.
- [x] 자신이 가진 로또 번호가 보너스 숫자를 포함하는지 결과값 제공

#### LottoMoney

- 로또 구입 금액 값을 가진다.
- [x] 로또 구입 금액이 1000원 이하면 예외를 발생시킨다

#### LottoGame

- 구입 금액에 따라 LottoNumbers를 여러개 생성한 값을 가진다.
- [ ] 구입 금액에 따라 LottoNumbers를 여러 개 생성한다.
- [ ] 당첨 번호에 따라 당첨 정보를 반환한다.
- [ ] 당첨 정보에 따라 수익률을 반환한다.


#### Rank

- 로또 당첨 순위
- 몇 개의 숫자가 맞는지, 맞으면 당첨금이 얼마인지에 대한 정보를 가진다.
- [x] 맞은 숫자에 따라 적합한 당첨순위를 반환한다

#### WinningInfo

- Rank를 몇 번 맞췄는지 기록한다.
- [ ] 맞춘 숫자를 증가시킨다.

#### WinningInfos

- 로또 게임 순위들을 몇번 맞췄는지(WinningInfo)에 대한 정보를 여러개 가진다.
- [ ] 순위 정보를 업데이트 시킨다.
- [ ] 총 당첨금을 반환한다.

### 의문점

- 같이 사용할 수 있는 역할이 있는 것 같아서 합친게 있는데, (LottoNumbers = LottoWinningNumbers, LottoMoney = LottoWinningMoney) 
사용처가 다른데 합치는게 맞는지 아닌지 헷갈림