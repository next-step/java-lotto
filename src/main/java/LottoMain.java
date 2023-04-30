import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        Money money = InputView.inputPrice();
        OutputView.printLottoQuantity(money, Lotto.getLottoFee());

        List<Lotto> lottoList = LottoMachine.issueAutoForMoney(money);
        OutputView.printLottoList(lottoList);

        WinnerLotto winnerLotto = InputView.inputWinningNumbers();
        Statistics statistics = new Statistics(winnerLotto);

        OutputView.printStatisticsResult(statistics,lottoList);
        OutputView.printProfit(statistics,lottoList,money);
     }
}
