package lotto;

import lotto.domain.Lotto;
import lotto.domain.Ranks;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int amount = InputView.inputAmount();

        Lotto lotto = new Lotto(amount);
        ResultView.printTicketCount(lotto.getTicketCount());
        ResultView.printTickeList(lotto.getTicketList());

        List<Integer> winnigNumbers = InputView.inputWinnigNumber();
        Ranks ranks = lotto.rankedWinningNumbers(winnigNumbers);

        ResultView.printLottoResult(ranks);
        ResultView.printIncomePercentage(ranks.caculateIncomePercentage());
    }
}
