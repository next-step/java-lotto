# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

---
### 모델링
##### InputView
* 구입금액 입력
* 지난주 당첨번호 입력

##### LottoNumberFactory
* 랜덤으로 LottoNumber 6개 뽑는다
    * Collections.shuffle() 사용

##### LottoNumber
* 값은 1부터 45까지 중 하나이다.

##### LottoGame
* 로또 1장(숫자 6개)당 1000원
* 지난주 당첨번호와 발급한 로또 번호들 비교

##### WinningMoney
* 3개 일치하면 5000원
* 4개 일치하면 50000원
* 5개 일치하면 1500000원
* 6개 일치하면 2000000000원

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
