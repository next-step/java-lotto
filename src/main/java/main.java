import Order.LottoOrder;
import casino.Casino;
import lotto.Lotto;
import lotto.LottoFactory;
import lotto.WinningLotto;

import java.util.*;

import static util.StringConverter.StringToIntegerList;
import view.InputView;
import view.ResultView;

public class main {
    public static void main(String[] args) {
        int[] winners = new int[6];

        int amount = InputView.getAmount();
        int manualAmount = InputView.getManualAmount();
        List<List<Integer>> manualNumbers = InputView.getManualLottoNumber(manualAmount);

        LottoOrder lottoOrder = new LottoOrder(amount, manualAmount);
        List<Lotto> lottoTickets = Casino.buyLotteryWithManual(lottoOrder, manualNumbers);
        ResultView.printLottoNumber(lottoTickets);

        String inputString = InputView.getWinningNumber();
        List<Integer> winningNumber = StringToIntegerList(inputString);

        int bonus = InputView.getBonusNumber();
        WinningLotto winningLotto = LottoFactory.manualWinningLotto(winningNumber, bonus);

        for(Lotto lotto : lottoTickets) {
            int result =
                    Casino.match(lotto, winningLotto);
            winners[result-1] ++;
        }

        ResultView.printWinningResult(winners);
        ResultView.printProfit(winners, amount);
    }
}
