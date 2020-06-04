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
        OutputView.printBuyLottos(lottosBought);

        final String winningNumber = InputView.inputWinningNumber();
        final int bonus = InputView.inputBonusNumber();
/*
        final WinningLotto winningLotto = new WinningLotto(winningNumber, bonus);
        LottosStatistics statistics = new LottosStatistics(lottosBought,
                BigDecimal.valueOf(buyPriceAmount),
                winningLotto);
        OutputView.printLottoStatistics(statistics);*/
    }
}
