package step2.controller;

import step2.domain.Lottos;
import step2.domain.Price;
import step2.domain.WinningResult;
import step2.domain.WinningType;
import step2.service.LottoService;
import step2.strategy.RandomNumberGenerator;
import step2.view.ResultView;

import java.util.Map;

public class LottoMachine {
    private Price price;
    private LottoService lottoService;

    private LottoMachine(int price) {
        this.price = Price.of(price);
        this.lottoService = new LottoService(new RandomNumberGenerator());
    }

    public static LottoMachine create(int price) {
        return new LottoMachine(price);
    }

    public Lottos purchase() {
        Lottos lottos = lottoService.purchase(price.getPrice());
        showPurchaseResult(lottos);
        return lottos;
    }

    private void showPurchaseResult(Lottos lottos) {
        ResultView.showLottoGenerateCount(lottos.getLottosSize());
        ResultView.showAllLottoNumbers(lottos.getLottos());
        System.out.println();
    }

    public void winningResult(Lottos purchasedLottos, String winningNumbers, int bonusNumber) {
        WinningResult winningResult = lottoService.winningResult(purchasedLottos, winningNumbers, bonusNumber);
        showWinningStatistics(winningResult);
    }

    private void showWinningStatistics(WinningResult winningResult) {
        System.out.println();
        ResultView.showWinningStatistics();
        showWinningResultOfWinningType(winningResult);
        ResultView.showWinningResultOfRevenue(price, winningResult.totalWinnings());
    }

    private void showWinningResultOfWinningType(WinningResult winningResult) {
        Map<WinningType, Integer> winningResultMap = winningResult.getWinningResult();
        for (WinningType type : winningResultMap.keySet()) {
            checkBonusType(type, winningResultMap);
        }
    }

    private void checkBonusType(WinningType type, Map<WinningType, Integer> winningResultMap) {
        if (WinningType.SECOND_BONUS.equals(type)) {
            ResultView.showBonusWinningResultOfWinningType(type.getMatchCount(), type.getWinnings(), winningResultMap.get(type));
            return;
        }
        ResultView.showWinningResultOfWinningType(type.getMatchCount(), type.getWinnings(), winningResultMap.get(type));
    }
}
