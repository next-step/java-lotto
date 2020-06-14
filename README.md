# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 요구사항
* InputView
    * 로또 구입 금액을 입력
    * 수동으로 구매할 로또 수 입력
    * 수동으로 구매할 로또 번호 입력  
* Money
    * 로또 1장의 가격은 1000원
    * 수익률 = (당첨 금액) / (로또 구입 금액)
    * 수익률 소수 둘째자리 아래는 버린다.
* Lotto
    * 로또 번호 6개
    * 당첨 번호와 비교
* LottoNumber
    * 로또 번호 하나
* LottoMachine
    * 수동 로또 생성
    * Collections.shuffle() 사용하여 로또 자동 생성
    * 로또 정렬
* WinningNumber
    * 당첨 로또 번호
* Rank
    * enum
    * 당첨 금액
* LottoResult
    * 구입한 모든 로또에 대한 결과 저장
* ResultView
    * 결과 출력

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
