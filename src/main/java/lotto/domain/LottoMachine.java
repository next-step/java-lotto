package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    private Money money;
    private List<Lotto> lottos;

    public LottoMachine(Money money) {
        this.money = money;
        validatePurchasable();
        this.lottos = generateLottos();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private List<Lotto> generateLottos() {
        List<Lotto> generatedlottos = new ArrayList<>();
        for (int i = 0; i < money.getPurchasableCount(LOTTO_PRICE); i++) {
            generatedlottos.add(new Lotto());
        }
        return generatedlottos;
    }

    private void validatePurchasable() {
        if (money.getPurchasableCount(LOTTO_PRICE) < 1) {
            throw new RuntimeException("돈이 부족합니다.");
        }
    }
}
