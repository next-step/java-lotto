package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCheck;
import lotto.domain.LottoRank;
import lotto.domain.LottoStore;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int buyPriceAmount = InputView.inputBuyAmount();
        List<Lotto> lottosBought = LottoStore.buy(buyPriceAmount);
        OutputView.printBuyLottoCount(lottosBought.size());
        OutputView.printLottos(lottosBought);
        OutputView.printNewLine();

        final String winningNumber = InputView.inputWinningNumber();
        OutputView.printNewLine();

        OutputView.printWinningLottoTitle();
        OutputView.printDashBar();

        LottoCheck lottoCheck = LottoCheck.newInstance(lottosBought, winningNumber);
        for(LottoRank lottoRank : LottoRank.getWinningLotto()) {
            OutputView.printSameCountWinningNumber(lottoRank,
                    lottoCheck.getWinningLottoCount(lottoRank));
        }

        OutputView.printReturnValue(lottoCheck.getWinningAmount(),
                BigDecimal.valueOf(buyPriceAmount));
    }
}
