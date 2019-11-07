package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.data.Lottos;

public class VendingMachine {
    private LottoPrice lottoPrice;

    public VendingMachine(int budget) {
        this.lottoPrice = new LottoPrice(budget);
    }

    public Lottos buy() {
        List<Lotto> lottos = new ArrayList<>();

        while (lottoPrice.isEnoughBudget()) {
            lottos.add(new Lotto());
        }

        return new Lottos(lottos);
    }

    public int getExpend() {
        return lottoPrice.getExpend();
    }
}
