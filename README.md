# 로또 기능 구현 목록
## 로또
- 총 6개의 로또 번호로 구성된다.
- 6개의 로또 번호는 중복 될 수 없다.

## 로또 번호 
- 로또 번호는 1이상 45이하의 수로 구성된다.

## 상점
- 로또를 발급한다.
- 로또 1장의 가격은 1000원이다.

## 당첨
- 로또의 당첨 번호의 수가 다음과 같을 때 다음 금액을 가집니다.
    - 3개 일치 시 : 5000원
    - 4개 일치 시 : 50000원
    - 5개 일치 시 : 1500000원
    - 6개 일치 시 : 2000000000원
    - 그 외 : 0원

## 통계
- 발급된 로또들을 가지고 있다.
- 발급된 로또들의 당첨 통계를 가지고 있다.
- 지난 주 당첨번호를 가지고 있다.
- 발급된 로또의 결과를 가지고 있다. 
- 수익률을 가지고 있다.

## 수익률
- 수익률 = 당첨 금액 / 총 구입 금액 * 100

## 메인
1. 구매 금액을 사용자으로부터 받는다.
2. 구매한 모든 로또를 출력한다.
3. 지난 주 당첨 번호를 사용자으로부터 입력 받는다. (, 단위로 구분)
4. 당첨 통계와 수익률을 출력한다.



