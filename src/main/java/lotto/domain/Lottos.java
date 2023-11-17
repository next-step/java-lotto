package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public Lottos(int value) {
        this.lottos = new ArrayList<>();
        for (int game = 0; game < purchasableLottoCount(value); game++) {
            this.lottos.add(new Lotto());
        }
    }

    private int purchasableLottoCount(int value) {
        return value / Lotto.LOTTO_PRICE;
    }

    public int totalWinningAmount(String winningNumber) {
        WinningAmount winningAmount = new WinningAmount();
        for (Lotto lotto : this.lottos) {
            winningAmount.add(lotto.winningInfo(winningNumber).getWinningAmount());
        }
        return winningAmount.amount();
    }

    public BigDecimal rateOfReturn(String winningNumber) {
        BigDecimal purchaseAmount = new BigDecimal(this.lottos.size() * Lotto.LOTTO_PRICE);
        BigDecimal winningAmount = new BigDecimal(totalWinningAmount(winningNumber));

        return winningAmount.divide(purchaseAmount, 2, RoundingMode.HALF_UP);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public int size() {
        return this.lottos.size();
    }

    public int winningCount(String winningNumber, int correctCount) {
        return (int) this.lottos.stream()
                .filter(lotto -> lotto.winningInfo(winningNumber).getCorrectCount() == correctCount)
                .count();
    }
}
