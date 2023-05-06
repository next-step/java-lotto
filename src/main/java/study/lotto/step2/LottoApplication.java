package study.lotto.step2;

import study.lotto.step2.application.LottoSeller;
import study.lotto.step2.domain.*;
import study.lotto.step2.presentation.LottoResultsStatisticOutputView;
import study.lotto.step2.presentation.LottosInformationOutputView;

import static study.lotto.step2.presentation.ConsoleInputView.*;

public class LottoApplication {
    public static void main(String[] args) {
        Lottos lottos = lottoSeller().sell(lottoPurchase());
        LottosInformationOutputView lottosInformationOutputView = new LottosInformationOutputView(lottos);
        lottosInformationOutputView.printInformation();

        LottoResults lottoResults = winningLotto().resultsOf(lottos);
        LottoResultsStatisticOutputView lottoResultsStatisticOutputView = new LottoResultsStatisticOutputView(lottoResults);
        lottoResultsStatisticOutputView.printWinningStatistic();
    }

    private static LottoPurchase lottoPurchase() {
        return new LottoPurchase(askPurchaseAmount());
    }

    private static WinningLotto winningLotto() {
        return new WinningLotto(askLastWeekWinningNumbers());
    }

    private static LottoSeller lottoSeller() {
        return new LottoSeller(lottoFactory());
    }

    private static LottoFactory lottoFactory() {
        return new LottoFactory(randomNumberSelector());
    }

    private static LottoNumbersFactory randomNumberSelector() {
        return new RandomLottoNumbersFactory();
    }
}
