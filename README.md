# java-lotto

로또 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

### 요구사항

- 1000*N원을 넣으면, N장의 로또를 구매할 수 있다.
    - 정책 : 입력을 받는다.
    - 세부사항 : 어떻게 입력을 받는지.
- 로또번호(1번 ~ 45번)는 랜덤으로 생성된다.
  - [x] 로또번호는 1~45다.
  - [x] 1~45사이의 중복되지않는 번호들을 생성한다
- [x] 로또하나는 6개의 로또번호로 구성된다.
- 당첨번호와 하나의 로또티켓을 비교해서, 몇등인지 알려준다.
- 등수에 맞는 상금이 있다.
- 결과로 상금의 합과 구매 금액을 비교해서 수익률을 알려준다.

---

## 도메인

### LottoNumber

- [x] 로또번호는 1~45다.

LottoTicket 1 -> 1 LottoNumbers 1 -> * LottoNumber

### LottoNumbers

- [x] 1~45사이의 중복되지않는 번호들을 생성한다
- [x] 당첨티켓과 로또티켓을 비교한다.
- [x] LottoNumber가 포함되는지 확인할 수 있다.
- [x] LottoNumbers 입력과 일치되는 개수 반환
- [x] 6개의 로또 번호를 가진다.

### LottoReward

- [x] 등수에 맞는 상금이 있다.

### LottoResult

- [x] 내 로또티켓과 당첨결과를 비교해서 몇개의 로또가 맞았는지, 보너스도 맞았는지 알려준다.

### LottoBonus

- [x] 같은 로또 번호를 가지면 같다.
- [x] 로또번호들과 보너스 번호가 중복되는지 체크할 수 있다.
- [x] 보너스가 LottoNumbers에 포함되는지 확인한다

### LottoPrize

- [x] 당첨갯수와, 보너스번호당첨 유무를 받아, 몇번째 등수인지 반환한다
- [x] 

## 서비스

### LottoService

- [x] 유저가 여러개의 로또를 구매할 수 있다.
- [x] 본인이 가진 티켓들의 결과를 얻을 수 있다.

## LottoController -> LottoService -> 로도를 체크한다. domain

- checkLotto ->
- buyRandom ->

## 외부

### RandomLottoNumberGenerator

- [x] 1~45사이의 중복되지않는 랜덤한 번호들을 생성한다

구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.   
1
2, 3, 4, 5, 6   
보너스 볼을 입력해 주세요.   
7

로또 결과와 내 티켓을 확인해서 상금을 반환한다

method 내 티켓 비교하기   
내티켓,당첨 티켓 만들기   
내티켓 당첨티켓 비교 해서, 갯수확인   
보너스 볼과 내 티켓 비교   
내 티켓이 보너스볼에 포함되면, 2등이다

수합한다
그게아니면, 등수로 치환한다.

서비스

등수를 상금으로 바꾼다

당첨 볼

당첨티켓과 보너스볼을 가지고있는, 관리인? 이 따로있다. <- 도메인이다.

당첨볼 - 내 티켓 비교 -> 나 명?

당첨티켓(당첨번호 6, 보너스번호는 객체) -> 당첨번호(LottoNumber), 보너스번호(LottoNumber)


당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)

### 해야할 것

- lottoCache 상수 이름바꾸기
- LottoNumber static블록 위치 변경

내 티켓과 로또 결과를 받아서, 비교한다음, 결과를 반환한다.

돈을 받아서,

리스트 로또 티켓이 들어와서
수익율,prize마다의 갯수를 반환한다
