package lotto;

import java.util.ArrayList;
import java.util.List;

public class PurchaseHistory {
    private final int payment;
    private final List<Lotto> lottos = new ArrayList<>();

    public PurchaseHistory(final int amount, LottoGenerator lottoGenerator) {
        this.payment = amount;
        if (isNotEnoughMoney()) {
            throw new RuntimeException("금액이 부족하여 로또를 구매할 수 없습니다.");
        }

        int numberOfLotto = calculateNumberOfLotto();
        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(lottoGenerator.generateLotto());
        }
    }

    private boolean isNotEnoughMoney() {
        return payment < Lotto.UNIT_PRICE;
    }

    private int calculateNumberOfLotto() {
        return payment / Lotto.UNIT_PRICE;
    }

    public int getPayment() {
        return payment;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
