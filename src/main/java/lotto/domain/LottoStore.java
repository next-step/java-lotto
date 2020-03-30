package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int PRICE = 1000;

    public static List<Lotto> sellLotto(int money) {
        List<Lotto> lottos = new ArrayList<>();

        int lottoCount = money / PRICE;

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(LottoGenerator.generate());
        }

        return lottos;
    }
}
