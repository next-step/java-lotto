package lotto.domain;

import lotto.constant.MatchResult;

public class LottoBuyer {

    private final int purchaseAmount;
    private Lottos lottos;

    public LottoBuyer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void buyLottos() {
        LottoStore lottoStore = new LottoStore(purchaseAmount);
        lottos = lottoStore.sellLotto();
    }

    public void confirmLottos(WinningNumbers lastWinningNumbers) {
        lottos.confirmAll(lastWinningNumbers);
    }

    public double calculateProfitRate() {
        return (double) lottos.calculateTotalWinPrice() / (double) purchaseAmount;
    }

    public Lottos lottos() {
        return lottos;
    }

    public int countMatchResult(MatchResult matchResult) {
        return lottos.countMatchResult(matchResult);
    }
}
