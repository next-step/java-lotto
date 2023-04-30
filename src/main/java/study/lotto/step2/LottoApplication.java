package study.lotto.step2;

import study.lotto.step2.application.LottoReader;
import study.lotto.step2.application.LottoSeller;
import study.lotto.step2.domain.*;
import study.lotto.step2.presentation.LottoResultsStatistic;
import study.lotto.step2.presentation.LottosInformation;

import static study.lotto.step2.presentation.ConsoleInputUtil.*;

public class LottoApplication {
    public static void main(String[] args) {
        Lottos lottos = lottoSeller().sell(askPurchaseAmount());
        LottosInformation lottosInformation = new LottosInformation(lottos);
        lottosInformation.printInformation();

        LottoResults lottoResults = lottoReader().resultOf(lottos);
        LottoResultsStatistic lottoResultsStatistic = new LottoResultsStatistic(lottoResults);
        lottoResultsStatistic.printWinningStatistic();
    }

    private static LottoReader lottoReader() {
        return new LottoReader(askLastWeekWinningNumbers());
    }

    private static LottoSeller lottoSeller() {
        return new LottoSeller(lottoFactory());
    }

    private static LottoFactory lottoFactory() {
        return new LottoFactory(randomNumberSelector());
    }

    private static AutoNumberSelector randomNumberSelector() {
        return new RandomNumberSelector();
    }
}
