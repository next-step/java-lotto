package lottogame.controller;

import lottogame.domain.*;
import lottogame.ui.LottoInputView;
import lottogame.ui.LottoOutputView;

public class LottoController {
    public void run() {
        int buyAmount = LottoInputView.getBuyAmount();
        Lottos lottos = purchaseLottos(buyAmount);
        printPurchaseInfo(lottos);

        Lotto winningLotto = getWinningLotto();
        LottoNumber bonusNumber = getBonusNumber();

        LottoGameService gameService = new LottoGameService(lottos, buyAmount);
        double prizeRate = gameService.calculatePrizeAmount(new WinningLotto(winningLotto, bonusNumber));

        LottoOutputView.printWinningStatistics(gameService.getWinningResultsByRank());
        LottoOutputView.printPrizeRate(prizeRate);
    }

    private Lottos purchaseLottos(int buyAmount) {
        int lottoCount = buyAmount / LottoGameConstants.LOTTO_PRICE;
        return new Lottos(lottoCount);
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
