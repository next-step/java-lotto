package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoPaper;
import lotto.domain.Money;
import lotto.domain.WinningResults;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {

        // 금액 입력
        Money money = new Money(InputView.inputPurchasePrice());

        // 총 구매 티켓 수 알림
        ResultView.announceTotalLottoTicketCount(money.countOfLottoPurchases());

        // 구매 티켓 번호 출력
        LottoPaper lottoPaper = new LottoMachine().buyLotto(money);
        ResultView.announceTotalLottoNumbers(lottoPaper);

        // 지난주 당첨 번호 입력
        WinningResults winningResults = new WinningResults(InputView.inputWinningNumbersLastWeek());

        // 결과 체크
        winningResults.checkWinning(lottoPaper);

        // 결과 출력
        ResultView.resultStart();
        ResultView.WinningResult(winningResults);
    }
}
