package lotto;

import lotto.domain.Lotto;
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
        lotto.rankedWinningNumbers(winnigNumbers);

        ResultView.printLottoResult(lotto);
        ResultView.printIncomePercentage(lotto.caculateIncomePercentage());
    }
}
