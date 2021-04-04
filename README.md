# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 구현대상 소스
### [UI]
* LottoAutoApplication : 로또 진행을 위한 UI App
* InputView : 구입금액, 당첨번호 입력처리를 위한 입력 기능 view
* ResultView : 구매리스트, 당첨결과 출력을 위한 출력 기능 view
### [Presentation Layer]
* LottoPurchaseController : 수동 및 자동로또 구매 처리를 위한 API 진입소스
* LottoWinInquiryController : 로또 당첨결과 조회를 위한 API 진입소스
* LottoAutoPurchaseRequest : 수동 및 자동로또 구매정보를 저장하는 Input dto 클래스
* LottoAutoPurchaseResponse : 로또티켓 구매결과를 리턴해주기 위한 Output dto 클래스
* WinInquiryRequest : 로또 당첨조회를 위한 Input dto 클래스
* WinInquiryResponse : 로또 당첨조회를 위한 output dto 클래스
* WinStatistic : 로또 당첨 통계정보를 담고있는 output dto 클래스
### [Service Layer]
* LottoPurchaseService : 로또티켓 구매가능 검증과 구매처리를 위한 서비스 클래스
* LottoManualService : 로또 수동구매 처리를 위한 서비스 클래스  
* LottoAutoService : 로또 자동구매 처리를 위한 서비스 클래스
* LottoWinService : 로또 당첨조회 기능을 갖는 서비스 클래스
### [Domain Layer]
* LottoTicket : 여러 건의 로또를 표현하는 티켓 한 장
* LottoTickets : 로또티켓 여러 장의 집계정보를 제공하기 위한 일급컬렉션 클래스  
* Lotto : 6개의 숫자를 갖는 로또복권 한 건
* LottoNumber : 로또 숫자 하나
* LottoRank : 로또 등수와 당첨금액 정보를 표현하기 위한 enum 클래스
* LottoRanks : 로또 수익률과 등수별 당첨정보를 제공하기 위한 일급컬렉션 클래스
* LottoConstant : 로또복권과 관련된 상수들의 모임 클래스
* LottoTicketType : 로또티켓의 유형을 구분하기 위한 enum 클래스