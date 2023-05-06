package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(1, 46)
        .boxed()
        .collect(Collectors.toList());

    private final Integer generateNumber;

    public LottoGenerator(Integer generateNumber) {
        this.generateNumber = generateNumber;
    }

    public List<Lotto> generate() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < generateNumber; i++) {
            Collections.shuffle(LOTTO_NUMBERS);
            lottos.add(new Lotto(LOTTO_NUMBERS.subList(0, 6)));
        }
        return lottos;
    }

}
