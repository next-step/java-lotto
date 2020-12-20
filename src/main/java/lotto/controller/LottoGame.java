package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoGame {

    public void run() {
        int purchasedAmount = readPurchasingAmount();
        printPurchasedLottoSize(purchasedAmount);
        Lottos lottos = new Lottos(purchasedAmount / Lotto.PRICE);
        printNumbersForLottos(lottos);
        LottoResult lottoResult = lottos.retrieveStatistics(readWinningLottoNumbers(), readBonusLottoNumber());
        printStatisticsForLottos(lottoResult);
    }
}
