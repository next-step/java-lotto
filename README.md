# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
  * 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


step1
* feature/requirements-unit-test
  * created test code based on the requirements provided
  * created methods based on test codes
* feature/implement-application
  * application implemented
* refactor/string-calculator
  * refactored codes

step2
* feature/lotteryDrawer-requirements
  * test codes based on requirements 
* feature/implement-lottery-application
  * implemented applications
  * test codes modified
* refactor/step1
  * refactored codes based on feedback
* refactor/lottery-application
  * refactored codes using stream()
* refactor/feedback
  * refactored codes based on feedback
    * validate input from system 
      * convert int to Integer -> able to test null and throw exception
    * used MagicNumber as Constant
* refactor/feedback-from-lecture
  * refactored codes after lecture
    * renamed all objects lottery -> lottoTicket or else
    * test codes are also refactored
      * remove //Given //When // Then
    * LotteryNumbers removed, LottoNumber created

step 3
* feature/bonus-ball
  * add bonus ball in WinningLotto
  * modified WinPrizeType.SECOND deal with bonusNumber
  * refactored if() -> if () based on coding convention

step 4
* feature/manual-pick
  * add manual-pick mode
    * refactored lottoTickets into manualTickets & quickTickets
      * LottoTickets Factory (LottoTicketsDispenser) created
      * both(manual&quick) test codes are created
      * lottoTickets test codes and related test codes are modified
    * InputView and ResultView modified
    * optimized imports
    * unchanged naming rules changed (lottery -> lotto)