package lotto.domain;

import lotto.constant.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;
    private final Lottos lottos;

    public LottoGame(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount(purchaseAmount); i++) {
            lottos.add(Lotto.createAutoLotto());
        }

        this.lottos = new Lottos(lottos);
        this.purchaseAmount = purchaseAmount;
    }

    private int purchaseCount(int purchaseAmount) {
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
