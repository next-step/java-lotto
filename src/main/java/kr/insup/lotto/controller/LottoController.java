package kr.insup.lotto.controller;

import kr.insup.lotto.config.LottoConfig;
import kr.insup.lotto.domain.Lottos;
import kr.insup.lotto.domain.Statistics;
import kr.insup.lotto.utils.WinningNumberParser;
import kr.insup.lotto.view.LottoView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int price = LottoView.getPrice();
        LottoView.showPurchase(price / LottoConfig.LOTTO_PRICE);
        Lottos lottos = new Lottos(price / LottoConfig.LOTTO_PRICE);
        LottoView.showLottoList(lottos);
        List<String> winningNumber = WinningNumberParser.parseWinningNumberToList(LottoView.showWinningNumber());
        Statistics statistics = lottos.statistics(winningNumber);
        LottoView.showWinningStatistic(statistics);
    }
}
