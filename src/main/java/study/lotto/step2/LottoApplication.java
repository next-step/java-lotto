package study.lotto.step2;

import study.lotto.step2.application.LottoReader;
import study.lotto.step2.application.LottoSeller;
import study.lotto.step2.domain.*;
import study.lotto.step2.presentation.LottoResultsStatistic;
import study.lotto.step2.presentation.SoldLottosInformation;

import static study.lotto.step2.presentation.ConsoleInputUtil.*;

public class LottoApplication {
    public static void main(String[] args) {
        SoldLottos soldLottos = lottoSeller().sell(askPurchaseAmount());
        SoldLottosInformation soldLottosInformation = new SoldLottosInformation(soldLottos);
        soldLottosInformation.printInformation();

        LottoResults lottoResults = lottoReader().resultOf(soldLottos);
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
