package lotto.domain;

import lotto.constant.Rank;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;
    private final Lottos lottos;

    public LottoGame(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = Lottos.createAutoLotto(purchaseCount());
    }

    private int purchaseCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public void confirmLottos(LottoNumbers lastWinningNumbers, LottoNumber bonusNumber) {
        lottos.confirmAll(lastWinningNumbers, bonusNumber);
    }

    public double calculateProfitRate() {
        return (double) lottos.calculateTotalWinPrice() / (double) purchaseAmount;
    }

    public Lottos lottos() {
        return lottos;
    }

    public int countMatchResult(Rank rank) {
        return lottos.countMatchResult(rank);
    }
}
