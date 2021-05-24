package kr.insup.lotto.controller;

import kr.insup.lotto.config.LottoConfig;
import kr.insup.lotto.domain.Lotto;
import kr.insup.lotto.domain.Lottos;
import kr.insup.lotto.domain.Statistics;
import kr.insup.lotto.domain.WinningLotto;
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

        int attempt = price / LottoConfig.LOTTO_PRICE;

        LottoView.showPurchase(attempt);
        Lottos lottos = new Lottos(attempt);
        LottoView.showLottoList(lottos);

        WinningLotto winningNumber;

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
            LottoView.printWrongPriceFormat();
        }

        return price;
    }

    private static WinningLotto winningNumber() {
        WinningLotto winningNumber = null;
        String winningNumberInput = LottoView.showWinningNumber();

        try {
            List<Integer> winningNumberList = WinningNumberParser.parseWinningNumberToList(winningNumberInput);
            Integer bonusNumber = LottoView.showBonusNumber();
            winningNumber = new WinningLotto(winningNumberList, bonusNumber);
        } catch (NumberFormatException nfe) {
            LottoView.printWrongWinningNumberFormat();
        } catch (IllegalArgumentException e) {
            LottoView.printIllegalArgument(e.getMessage());
        }

        return winningNumber;
    }
}
