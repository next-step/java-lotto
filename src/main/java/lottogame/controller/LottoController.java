package lottogame.controller;

import lottogame.domain.LottoGameService;
import lottogame.domain.lotto.*;
import lottogame.domain.strategy.PredefinedLottoNumberStrategy;
import lottogame.ui.LottoInputView;
import lottogame.ui.LottoOutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    public void run() {
        int buyAmount = LottoInputView.getBuyAmount();

        int LottoCount = getLottoCount(buyAmount);
        int manualLottoCount = LottoInputView.getBuyManualLottoCount();
        List<String> manualLottoNumbers = LottoInputView.getBuyManualLottoNumbers(manualLottoCount);
        Lottos manualLottos = getManualLottos(manualLottoNumbers);
        Lottos autoLottos = getAutuLottos(LottoCount - manualLottoCount);
        Lottos lottos = Lottos.merge(manualLottos, autoLottos);
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

    private Lottos getManualLottos(List<String> manualLottoNumbers) {
        List<Lotto> lottos = manualLottoNumbers.stream()
                .map(numbers -> new Lotto(new PredefinedLottoNumberStrategy(numbers)))
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    private LottoNumber getBonusNumber() {
        int bonusNumber = LottoInputView.getBonusNumber();

        return new LottoNumber(bonusNumber);
    }
}
