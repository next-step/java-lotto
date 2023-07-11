# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 요구사항

## 입력

- 로또 구입 금액
    - [ ] 양수
    - [ ] 구입 금액은 천단위로 한다 (로또 1장 가격은 1000원)
- 당첨 번호
    - [ ] 쉼표로 구분한다
    - [ ] 숫자는 6개여야 한다
    - [ ] 중복 고려
    - [ ] 범위는 1~45
- 보너스 볼
    - [ ] 당첨 번호와 중복되지 않는다
    - [ ] 범위는 1~45

## 기능 구현

- 로또를 생성
    - [x] LottoNumber ->  범위는 1~45
    - [x] Lotto -> 6개의 LottoNumber , 서로 다른 6개 LottoNumber
    - [X] AutoLottoGenerator 는 Lotto 만든다.
    - [x] LottoPurchaser 가 AutoLottoGenerator 로 금액만큼 구매한다.

- 당첨 번호와 구매한 로또 결과 비교
    - [X] 당첨 번호와 보너스 볼은 중복되지 않는다.
    - [ ] 당첨 번호와 로또 번호 일치 개수를 구한다.
    - [ ] 5개가 일치시에 보너스와도 비교
    - [ ] 당첨 결과를 Enum 으로 저장

- 결과를 가져온 뒤에 수익률을 계산
    - [ ] 일치하는 값을 기준으로 수익률을 계산

## 출력

- 생성한 로또 번호를 출력한다.
    - [ ] 정렬해서 출력
    - [ ] 상황에 따라서 DTO , 도메인을 넘겨 받는다.

- 당첨 통계를 출력한다.
    - [ ] (Map<Rank,Integer> , 수익률) 을 넘겨 받고 출력한다.


