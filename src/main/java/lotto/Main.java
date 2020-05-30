package lotto;

import lotto.domain.*;
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
        final int bonus = InputView.inputBonusNumber();
        final WinningLotto winningLotto = new WinningLotto(winningNumber, bonus);
        OutputView.printNewLine();

        OutputView.printWinningLottoTitle();
        OutputView.printDashBar();

        for(LottoRank lottoRank : LottoRank.getWinningLotto()) {
            OutputView.printSameCountWinningNumber(lottoRank,
                    LottoCheck.getWinningLottoCount(lottosBought, winningLotto, lottoRank));
        }

        OutputView.printReturnValue(LottoCheck.getTotalWinningAmount(lottosBought, winningLotto),
                BigDecimal.valueOf(buyPriceAmount));
    }
}
