package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public static final String LINE_BREAK = "\n";
    private List<Lotto> lottos;

    public Lottos(final Amount purchaseAmount) {

        this.lottos = initLottos(purchaseAmount);
    }

    private List<Lotto> initLottos(final Amount purchaseAmount) {
        final List<Lotto> lottos = new ArrayList<>();

        final int purchaseCount = purchaseAmount.divide(Amount.ofLottoAmount());

        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

    public int purchaseCount() {
        return lottos.size();
    }

    public WinnerCount draw(final List<Integer> winningNumbers) {
        final WinnerCount winner = new WinnerCount();
        for (Lotto lotto : lottos) {
            winner.addWinner(lotto.getRightNumber(winningNumbers));
        }

        return winner;
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
