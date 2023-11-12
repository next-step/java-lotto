package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final String INVALID_AMOUNT = "로또 금액보다 높은 금액을 입력해야 합니다.";
    private static final int LOTTO_AMOUNT = 1000;
    public static final String LINE_BREAK = "\n";
    private List<Lotto> lottos;

    public Lottos(final int purchaseAmount) {
        validationCheck(purchaseAmount);

        this.lottos = initLottos(purchaseAmount);
    }

    private List<Lotto> initLottos(final int purchaseAmount) {
        final List<Lotto> lottos = new ArrayList<>();
        final int purchaseCount = purchaseAmount / LOTTO_AMOUNT;

        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

    private void validationCheck(final int purchaseAmount) {
        if (purchaseAmount < LOTTO_AMOUNT) {
            throw new IllegalArgumentException(INVALID_AMOUNT);
        }
    }

    public int purchaseCount() {
        return lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString() + LINE_BREAK);
        }
        return stringBuilder.toString();
    }

    public Winner draw(final List<Integer> winningNumbers) {
        final Winner winner = new Winner();
        for (Lotto lotto : lottos) {
            winner.addWinner(lotto.getRightNumber(winningNumbers));
        }

        return winner;
    }
}
