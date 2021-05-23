package kr.insup.lotto.controller;

import kr.insup.lotto.config.LottoConfig;
import kr.insup.lotto.domain.Lotto;
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
        Integer price;
        do {
            price = price();
        } while (price == null);

        LottoView.showPurchase(price / LottoConfig.LOTTO_PRICE);
        Lottos lottos = new Lottos(price / LottoConfig.LOTTO_PRICE);
        LottoView.showLottoList(lottos);

        Lotto winningNumber;
        do {
            winningNumber = winningNumber();
        } while (winningNumber == null);

        Statistics statistics = lottos.statistics(winningNumber);
        LottoView.showWinningStatistic(statistics);
    }

    private static Integer price() {
        Integer price = null;
        try {
            price = LottoView.getPrice();
        } catch (NumberFormatException e) {
            LottoView.printWrongNumberFormat();
        }
        return price;
    }

    private static Lotto winningNumber() {
        Lotto winningNumber = null;
        String winningNumberInput = LottoView.showWinningNumber();
        List<String> winningNumberList = WinningNumberParser.parseWinningNumberToLotto(winningNumberInput);
        try {
            winningNumber = new Lotto(winningNumberList);
        } catch (IllegalArgumentException e) {
            LottoView.printIllegalArgument();
        }
        return winningNumber;
    }
}
