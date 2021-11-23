package step2.controller;

import step2.domain.*;
import step2.service.LottoService;
import step2.strategy.RandomNumberGenerator;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;

    private Price price;
    private LottoService lottoService;

    private LottoMachine(int price) {
        this.price = Price.of(price);
        this.lottoService = new LottoService(new RandomNumberGenerator());
    }

    public static LottoMachine create(int price) {
        return new LottoMachine(price);
    }

    public Lottos purchase(int manualLottoCount) {
        int lottoCount = price.getPrice() / LOTTO_PRICE;
        int autoLottoCount = lottoCount - manualLottoCount;
        Lottos lottos = Lottos.create();
        lottos.addAll(purchaseManualLotto(manualLottoCount));
        lottos.addAll(purchaseAutoLotto(autoLottoCount));
        showPurchaseCountResult(manualLottoCount, autoLottoCount);
        showPurchaseResult(lottos);
        return lottos;
    }

    private List<Lotto> purchaseManualLotto(int manualLottoCount) {
        InputView.inputManualLottoNumberMessage();
        List<Lotto> lottos = new ArrayList<>();
        for (int purchaseCount = 0; purchaseCount < manualLottoCount; purchaseCount++) {
            String manualLottoNumber = InputView.inputManualLottoNumber();
            lottos.add(lottoService.purchaseManualLotto(manualLottoNumber));
        }
        System.out.println();
        return lottos;
    }

    private List<Lotto> purchaseAutoLotto(int autoLottoCount) {
        Lottos lottos = lottoService.purchase(autoLottoCount);
        return lottos.getLottos();
    }

    private void showPurchaseCountResult(int manualLottoCount, int autoLottoCount) {
        ResultView.showLottoGenerateCount(manualLottoCount, autoLottoCount);
    }

    private void showPurchaseResult(Lottos lottos) {
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
