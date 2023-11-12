package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final String INVALID_AMOUNT = "로또 금액보다 높은 금액을 입력해야 합니다.";
    private static final int LOTTO_AMOUNT = 1000;
    private List<Lotto> lottos;

    public Lottos(final int purchaseAmount) {
        validationCheck(purchaseAmount);

        this.lottos = initLottos(purchaseAmount);
    }

    private List<Lotto> initLottos(final int purchaseAmount) {
        final List<Lotto> lottos = new ArrayList<>();
        final int lottoCount = purchaseAmount / LOTTO_AMOUNT;

        for (int i = 0; i < lottoCount; i++) {
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
            stringBuilder.append(lotto.toString() + "\n");
        }
        return stringBuilder.toString();
    }
}
