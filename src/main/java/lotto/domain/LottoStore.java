package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public static final int LOTTO_PRICE = 1000;

    public static Lottos sellAutomatic(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int maxAmount = money / LOTTO_PRICE;
        for (int i = 0; i < maxAmount; i++) {
            Lotto lotto = LottoFactory.generate();
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    public static Lottos sellManual(List<Lotto> lottos, int money) {
        if (money < lottos.size() * LOTTO_PRICE) {
            throw new IllegalArgumentException("수동 로또를 살 돈이 부족합니다");
        }
        return new Lottos(lottos);
    }
}
