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
        final Lotto winningLotto = Lotto.valueOf(winningNumber);
        OutputView.printNewLine();

        OutputView.printWinningLottoTitle();
        OutputView.printDashBar();

        for(LottoRank lottoRank : LottoRank.getWinningLotto()) {
            OutputView.printSameCountWinningNumber(lottoRank,
                    LottoCheck.getWinningLottoCount(lottosBought, winningLotto, lottoRank));
        }

        OutputView.printReturnValue(LottoCheck.getWinningAmount(lottosBought, winningLotto),
                BigDecimal.valueOf(buyPriceAmount));
    }
}
