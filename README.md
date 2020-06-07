# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

***
## step1 - 문자열 덧셈 계산기
* 빈 문자열 또는 null 값을 입력할 경우 0을 반환(예 : “” => 0, null => 0)
* 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
* 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
* 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
* “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
* 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)

***
## step2 - 로또(자동)
* 로또 구입 금액에 해당하는 로또 발급해야 함
* 로또 1장 가격은 1000원
* 구매금액을 입력받음.
* 구매한 로또갯수를 노출함.
* 로또 노출시 번호 랜덤으로 6자리 노출(1~45번까지)
* 지난주 당첨번호 입력 받음
* 당첨 통계 노출 (3~6개 일치 판별)
* 일치갯수에 따라 로또 구매갯수 대비 수익률 판별
* 수익률 = 당첨금/로또구매금액 (소수점 둘째자리까지 나머지 절삭)
* 수익률이 1보다 작으면 손해, 1보다 크면 이득

##진행중 step3 TODO list
* ~~lottotickets 의 confirmWinningResult메소드 리팩토링~~ 
* ~~LottoTickets -> 일급 콜렉션을 사용한다면 calculateTotalPrize / calculateEarningsRate 메소드를스스로 수행 할 수 있을 것 같아요.~~

## DONE list
* number 값 포장
* bonusBall 포장 -> lottoTicket의 checkWinningRank 리팩토링 가능
* lottotickets 의 confirmWinningResult메소드 리팩토링 
* WinningRank의 findRanking -> 매직넘버 변환
* LottoTicket -> validateLottoNumberMinMax 메소드 Integer 포장하면 해당 클래스에서 해결 가능할듯 (number값 포장)
* validateLottoNumberMinMax 메소드 매직넘벼 변환
* LottoTicket -> public static LottoTicket auto() {
                 return new LottoTicket(LottoNumber.getLottoNumbers());
                 }
                 LottoTicket.auto() 로 생성하실 수 있을 것 같아요.
* LottoTickets -> WinningLottoTicket 과 lastWinningNumbers.getBonusBall() 를 묶어서 객체로 관리
* LottoTickets -> 일급 콜렉션을 사용한다면 calculateTotalPrize / calculateEarningsRate 메소드를스스로 수행 할 수 있을 것 같아요.
* checkWinningRank 테스트 방법 찾기