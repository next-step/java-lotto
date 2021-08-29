package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoPaper;
import lotto.domain.Money;
import lotto.domain.WinningResults;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 금액 입력
        Money money = new Money(InputView.inputPurchasePrice());

        int countOfCustomLotto = InputView.inputCountOfCustomLotto(money);
        List<String> customLottos = InputView.inputCustomLotto(countOfCustomLotto);

        // 총 구매 티켓 수 알림
        ResultView.announceTotalLottoTicketCount(countOfCustomLotto, money.countOfLottoPurchases());

        // 구매 티켓 번호 출력
        LottoPaper lottoPaper = new LottoMachine().buyLotto(money, customLottos);
        ResultView.announceTotalLottoNumbers(lottoPaper);

        // 지난주 당첨 번호 입력
        WinningResults winningResults = new WinningResults(lottoPaper, InputView.inputWinningNumbersLastWeek(), InputView.inputBonusNumber());

        // 결과 출력
        ResultView.resultStart();
        ResultView.WinningResult(winningResults);
    }
}
