package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottos {

    private static final List<Integer> LOTTO_NUMBERS = Number.range();

    private AutoLottos() {}

    public static List<Lotto> autoCreate(final int countOfAutoLotto) {

        final List<Lotto> autoLottos = new ArrayList<>();
        for (int i = 0; i < countOfAutoLotto; i++) {
            Collections.shuffle(LOTTO_NUMBERS);
            autoLottos.add(Lotto.from(LOTTO_NUMBERS));
        }
        return autoLottos;
    }
}
