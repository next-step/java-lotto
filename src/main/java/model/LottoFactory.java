package model;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    public static List<Lotto> create(final LottoAmount lottoAmount) {
        final int number = lottoAmount.getAmount() / 1000;

        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        }
        return lottos;
    }
}
