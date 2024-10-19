package lottogame.controller;

import lottogame.domain.*;
import lottogame.ui.LottoInputView;
import lottogame.ui.LottoOutputView;

import java.util.List;

public class LottoController {
    public void run() {
        int buyAmount = LottoInputView.getBuyAmount();

        int LottoCount = getLottoCount(buyAmount);
        int manualLottoCount = LottoInputView.getBuyManualLottoCount();
        List<String> manualLottoNumbers = LottoInputView.getBuyManualLottoNumbers(manualLottoCount);

        Lottos lottos = getAutuLottos(LottoCount - manualLottoCount);
        printPurchaseInfo(lottos);

        Lotto winningLotto = getWinningLotto();
        LottoNumber bonusNumber = getBonusNumber();

        LottoGameService gameService = new LottoGameService(lottos, buyAmount);
        double prizeRate = gameService.calculatePrizeAmount(new WinningLotto(winningLotto, bonusNumber));

        LottoOutputView.printWinningStatistics(gameService.getWinningResultsByRank());
        LottoOutputView.printPrizeRate(prizeRate);
    }

    private int getLottoCount(int buyAmount) {
        return buyAmount / LottoGameConstants.LOTTO_PRICE;
    }

    private Lottos getAutuLottos(int count) {
        return new Lottos(count);
    }

    private void printPurchaseInfo(Lottos lottos) {
        LottoOutputView.printBuyAmount(lottos.getLottos().size());
        LottoOutputView.printLottos(lottos);
    }

    private Lotto getWinningLotto() {
        String stringNumbers = LottoInputView.getWinningNumbers();

        return new Lotto(new PredefinedLottoNumberStrategy(stringNumbers));
    }

    private LottoNumber getBonusNumber() {
        int bonusNumber = LottoInputView.getBonusNumber();

        return new LottoNumber(bonusNumber);
    }
}
