package kr.insup.lotto.controller;

import kr.insup.lotto.config.LottoConfig;
import kr.insup.lotto.domain.Lotto;
import kr.insup.lotto.domain.Lottos;
import kr.insup.lotto.domain.WinningLotto;
import kr.insup.lotto.utils.LottoNumberParser;
import kr.insup.lotto.view.LottoView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Integer price = priceLoop();
        Integer manualCount = manualCountLoop(price);
        Integer attempt = price / LottoConfig.LOTTO_PRICE;

        LottoView.showPurchase(attempt);

        Lottos lottos = new Lottos(attempt - manualCount, manualLotto(manualCount));

        LottoView.showLottoList(lottos, attempt - manualCount, manualCount);

        WinningLotto winningNumber = winningNumberLoop();

        LottoView.showWinningStatistic(lottos.statistics(winningNumber));
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
            List<Integer> winningNumberList = LottoNumberParser.parseLottoNumberToList(winningNumberInput);
            Integer bonusNumber = LottoView.showBonusNumber();
            winningNumber = new WinningLotto(winningNumberList, bonusNumber);
        } catch (NumberFormatException nfe) {
            LottoView.printWrongWinningNumberFormat();
        } catch (IllegalArgumentException e) {
            LottoView.printIllegalArgument(e.getMessage());
        }

        return winningNumber;
    }

    private static Integer manualCount() {
        Integer manualCount = null;

        try {
            manualCount = LottoView.getManualLottoCount();
        } catch (NumberFormatException nfe) {
            LottoView.printWrongPriceFormat();
        }

        return manualCount;
    }

    private static List<Lotto> manualLotto(int manualCount) {
        List<Lotto> manualLottos = null;

        try {
            manualLottos = LottoView.getManualLotto(manualCount);
        } catch (NumberFormatException nfe) {
            LottoView.printWrongManualNumberFormat();
        } catch (IllegalArgumentException e) {
            LottoView.printIllegalArgument(e.getMessage());
        }

        return manualLottos;
    }

    private static boolean checkIfManualCountGreaterThanAttempt(Integer attempt, Integer manualCount) {
        if (attempt < manualCount) {
            LottoView.printWrongManualCount();
            return true;
        }

        return false;
    }

    private static Integer priceLoop() {
        Integer price;

        do {
            price = price();
        } while (price == null);

        return price;
    }

    private static Integer manualCountLoop(Integer price) {
        Integer manualCount;

        do {
            manualCount = manualCount();
        } while (manualCount == null ||
                checkIfManualCountGreaterThanAttempt(price / LottoConfig.LOTTO_PRICE, manualCount));

        return manualCount;
    }

    private static WinningLotto winningNumberLoop() {
        WinningLotto winningNumber;

        do {
            winningNumber = winningNumber();
        } while (winningNumber == null);

        return winningNumber;
    }
}
