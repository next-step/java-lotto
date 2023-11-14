package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public static final String LINE_BREAK = "\n";
    private static final int LOTTO_AMOUNT = 1000;

    private List<Lotto> lottos;

    public Lottos(final Amount purchaseAmount) {
        this.lottos = initLottos(purchaseAmount);
    }

    private List<Lotto> initLottos(final Amount purchaseAmount) {
        final List<Lotto> lottos = new ArrayList<>();

        final int purchaseCount = purchaseAmount.divideWithoutDecimal(new Amount(LOTTO_AMOUNT));

        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

    public int purchaseCount() {
        return lottos.size();
    }

    public Winning draw(final List<Integer> winningNumbers) {
        final Winning winning = new Winning();
        for (Lotto lotto : lottos) {
            winning.addWinning(lotto.getRightNumber(winningNumbers));
        }

        return winning;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString() + LINE_BREAK);
        }
        return stringBuilder.toString();
    }
}
