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
        return value/Lotto.LOTTO_PRICE;
    }

    public int totalWinningAmount(String winningNumber) {
        int winnigAmount = 0;
        for (Lotto lotto : this.lottos) {
            winnigAmount += lotto.winningInfo(winningNumber).getWinningAmount();
        }
        return winnigAmount;
    }

    public BigDecimal rateOfReturn(String winningNumber) {
        BigDecimal purchaseAmount = new BigDecimal(this.lottos.size() * Lotto.LOTTO_PRICE);
        BigDecimal winningAmount = new BigDecimal(totalWinningAmount(winningNumber));

        return winningAmount.divide(purchaseAmount, 2, RoundingMode.HALF_UP);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public int winningCount(String winningNumber, int correctCount) {
        int winningCount = 0;
        for (Lotto lotto : this.lottos) {
            if (lotto.winningInfo(winningNumber).getCorrectCount() == correctCount) {
                winningCount += 1;
            }
        }
        return winningCount;
    }
}
