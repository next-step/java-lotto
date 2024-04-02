package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator implements NumbersGenerator {

    private static final List<Integer> base = new ArrayList<>();

    static {
        for (int i = 1; i < 45; i++) {
            base.add(i);
        }
    }

    public List<LottoNumber> generate() {
        Collections.shuffle(base);
        return base.subList(0, 6)
                .stream()
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());
    }
}
