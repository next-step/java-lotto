package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public StatisticsResult compareWith(Lotto previousWinningLotto) {
        Map<Prize, Integer> prizeCount = new HashMap<>();
        for (Lotto lotto : lottos) {
            Prize prize = Prize.fromNumberOfMatch(lotto.countNumberOfMatch(previousWinningLotto));
            prizeCount.put(prize, prizeCount.getOrDefault(prize, 0) + 1);
        }
        return new StatisticsResult(payment, prizeCount);
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
