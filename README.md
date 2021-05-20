# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

##요구 사항

* 금액에 따른 로또 구매 횟수를 정한다.
    * 구매 금액에 대한 원시값을 포장한다.
* 재활용이 가능한 랜덤 값을 생성하는 클래스를 만들자.
    * 번호 생성 로직을 만든다.
    * 번호 생성이 유효한지 체크하는 로직을 만든다.
    * 번호는 자동으로 값을 감싸도록 되며, 숫자의 범위도 체크가 가능하다.
* 구매한 만큼의 번호를 생성한다.
    * 생성 된 번호는 Set 자료구조에 담도록 한다.
    * 한 장의 로또는 Set이며 이 로또를 List에 담도록 한다.
* 당첨 번호를 입력 받고, 번호와 일치 되는지 체크하도록 한다.
    * 정렬을 이용하고, 낮은 번호부터 일치하는지 체크하도록 한다.
    * 통계는 Map을 활용하여 3,4,5,6개 일치와 카운트를 만들도록 한다.
* 당첨 통계와 구매 금액에 따른 수익률을 계산한다.
* 입력과 출력에 대한 클래스를 생성한다.