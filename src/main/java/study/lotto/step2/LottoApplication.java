package study.lotto.step2;

import study.lotto.step2.application.LottoSeller;
import study.lotto.step2.domain.*;
import study.lotto.step2.presentation.LottoResultsStatisticOutputView;
import study.lotto.step2.presentation.LottosInformationOutputView;

import static study.lotto.step2.presentation.ConsoleInputView.*;

public class LottoApplication {
    public static void main(String[] args) {
        Lottos lottos = lottoSeller().sell(askPurchaseAmount());
        LottosInformationOutputView lottosInformation = new LottosInformationOutputView(lottos);
        lottosInformation.printInformation();

        LottoResults lottoResults = winningLotto().resultsOf(lottos);
        LottoResultsStatisticOutputView lottoResultsStatisticOutputViewView = new LottoResultsStatisticOutputView(lottoResults);
        lottoResultsStatisticOutputViewView.printWinningStatistic();
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
