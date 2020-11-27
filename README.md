# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

##기능요구사항
* 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
* 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

##프로그래밍 요구사항
* 규칙 3: 모든 원시값과 문자열을 포장한다.
* 규칙 5: 줄여쓰지 않는다(축약 금지).
* 예외 처리를 통해 에러가 발생하지 않도록 한다.
* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
* java enum을 적용해 프로그래밍을 구현한다.
* 규칙 8: 일급 콜렉션을 쓴다.
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
* 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
* else 예약어를 쓰지 않는다.
    
##메소드 설명
* LottoController - gameStart()
* LottoMachine - 로또번호 생성관리객체
* LottoAUtoNumbers - 자동번호 가져오는 객체
* LottoWinningNumber - 로또 당첨번호 관리객체
    * getRank(List<integer> list) - 당첨등수 확인
        * return값
            * 1 = 1등
            * 2 = 2등
            * 3 = 3등
            * 4 = 4등
* LottoMatch - 로또번호 맞추기
* LottoStatusEnum - 로또상태 객체
* LottoShop - 로또 사는 객체
* LottoTicket - 로또 티켓 객체
* LottoRank - 로또 순위 구하기
* LottoProfitAmount - 1등부터 4등까지의 상금의 합 관리객체
* LottoNumber - 로또 번호 관리 객체
* LottoRankEnum - 맞힌 횟수에따른 랭크 반환 객체
* LottoManualNumber - 수동입력 관리 객체







## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)