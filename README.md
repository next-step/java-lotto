# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 구현 목록

1. 로또 클래스를 구현한다.
    - [X] 로또는 6개의 숫자 리스트를 가진다.
    - [X] 각 숫자는 1~45의 숫자만 입력받을 수 있다.
    - [X] 각 숫자는 중복될 수 없다.
2. 로또판매기 클래스를 구현한다.
    - [X] 로또 판매기는 클라이언트에게 구입 금액을 받으면 1장당 1000원의 로또를 발급한다.
    - [X] 1~45의 랜덤한 숫자를 생성해 로또를 생성한다.
3. 로또결과를 체크하는 클래스를 구현한다.
    - [V] 당첨번호 및 보너스볼을 입력받아 통계 정보를 리턴한다.
    - [ ] 당첨번호 및 보너스볼은 중복될 수 없다.
4. 클라이언트 클래스를 구현한다.
    - [ ] 금액을 입력받아 로또판매기로부터 로또를 구입한다.
    - [ ] 지난주 당첨번호 및 보너스볼을 입력받아 로또결과체커로부터 결과를 받는다.
    - [ ] 각 결과는 Viewer를 통해 출력한다.
    - [ ] 각 입력 값이 유효하지 않거나 에러를 발생시키는 경우, 에러메시지를 출력하고 재입력받는다.