package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class LottoGenerator {

    private final List<Integer> LOTTO_SET = new ArrayList<>();

    public LottoGenerator() {
        for (int i = 1; i < 46; i++) {
            LOTTO_SET.add(i);
        }
    }

    public List<Integer> generate() {
        Collections.shuffle(LOTTO_SET);
        return LOTTO_SET.subList(0, 6)
                .stream()
                .sorted(naturalOrder())
                .collect(toList());
    }

}
