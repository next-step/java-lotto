package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private LottoGenerator() {
    }

    public static List<Lotto> generate(Money price) {
        int amount = getAmount(new LottoPrice(price));
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public static int getAmount(LottoPrice lottoPrice) {
        return lottoPrice.getAmount();
    }
}
