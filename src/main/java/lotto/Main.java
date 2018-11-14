package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoResultSet;
import lotto.domain.LottoSet;
import lotto.domain.LottoShop;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Main {

    public static void main(String [] args) {
        int amount = InputView.inputPurchaseAmount();

        LottoSet lottoSet = LottoShop.buy(amount);
        ResultView.printLottoSet(lottoSet);

        List<Integer> target = InputView.inputLastWeeksNumbers();

        LottoMachine lottoMachine = new LottoMachine(lottoSet, target);
        LottoResultSet lottoResultSet = lottoMachine.createLottoResultSet();

        ResultView.printLottoResultSet(lottoResultSet);
        ResultView.printRateReturn(lottoResultSet.rateReturn(amount));
    }
}
