# 로또 기능 구현 목록
## 로또
- 총 6개의 로또 번호로 구성된다.
- 6개의 로또 번호는 중복 될 수 없다.

## 로또 번호 
- 로또 번호는 1이상 45이하의 수로 구성된다.

## 상점
- 로또를 자동 발급한다. (번호를 랜덤으로 선정하여 발급한다.)
- 로또를 수동 발급한다. (지정받은 번호를 이용하여 발급한다.)
- 로또 1장의 가격은 1000원이다.

## 당첨 로또 
- 당첨 번호(6개)와 당첨 보너스 번호(1개)를 가지고 있다.
- 당첨 번호와 당첨 보너스번호는 중복 될 수 없다.

## 당첨 기준
- 로또와 당첨 로또와 비교하여 매칭이 다음과 같을 때 다음 금액을 가집니다.
    - 1등 : 6개 일치 시 - 2000000000원
    - 2등 : 5개 일치 시, 보너스볼 일치 - 30000000원
    - 3등 : 5개 일치 시 - 1500000원
    - 4등 : 3개 일치 시 - 5000원
    - 5등 : 4개 일치 시 - 50000원   
    - 그 외 : 0원

## 로또 목록
- 발급된 로또들을 가지고 있다.

## 통계 
- 당첨 로또와 발급된 로또들을 통해 다음을 구할 수 있다.
    - 당첨 결과
    - 통계
    - 수익률

## 수익률
- 수익률 = 당첨 금액 / 총 구입 금액 * 100

## 메인
### 입력화면  
- 구매 금액을 사용자으로부터 받는다.
- 발급된 모든 로또를 출력한다.
- 지난 주 당첨 번호를 사용자으로부터 입력 받는다. (, 단위로 구분)
- 지난 주 당첨 보너스 번호를 사용자으로부터 입력 받는다.
### 결과 화면
- 로또목록의 당첨 통계와 수익률을 출력한다.



