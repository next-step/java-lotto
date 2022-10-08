package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLottos {

    public static final int LOTTO_INDEX_START = 0;
    public static final int LOTTO_INDEX_END = 6;
    private static final List<Integer> lottos = Number.range();

    private AutoLottos() {}

    public static List<Lotto> autoCreate(final long count) {

        final List<Lotto> autoLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Collections.shuffle(lottos);
            autoLottos.add(Lotto.from(pick()));
        }
        return autoLottos;
    }

    private static List<Integer> pick() {

        return lottos.subList(LOTTO_INDEX_START, LOTTO_INDEX_END)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
