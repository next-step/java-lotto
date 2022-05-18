package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoAutoMachine;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        int paying = InputView.inputMoney();

        int buyingCount = paying / LottoAutoMachine.PRICE;

        Lottos buyingLottos = LottoAutoMachine.makeLottos(buyingCount);
        ResultView.printBuyingLottos(buyingLottos);

        Lotto winningLotto = InputView.inputWinningNumber();

        ResultView.printWinningStatistics(buyingLottos.getTotalRank(winningLotto), buyingLottos.getTotalWinningMoney(winningLotto), paying);
    }

}

