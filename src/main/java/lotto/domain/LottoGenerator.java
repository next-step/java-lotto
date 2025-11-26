package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final long LOTTO_PRICE = 1000;
    private final long price;
    private final List<Lotto> lottos = new ArrayList<>();
    public LottoGenerator(long price) {
        this.price = price;
        generate();
    }

    private void generate() {
        long count = price / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
