package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int LOTTO_PRICE = 1_000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(MIN_LOTTO_NUMBER,
            MAX_LOTTO_NUMBER)
        .boxed()
        .collect(Collectors.toList());
    public static final int LOTTO_COUNT = 6;

    private final Integer generateNumber;

    public LottoGenerator(Integer money) {
        this.generateNumber = money / LOTTO_PRICE;
    }

    public Lottos generate() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < generateNumber; i++) {
            Collections.shuffle(LOTTO_NUMBERS);
            lottos.add(new Lotto(LOTTO_NUMBERS.stream()
                .limit(LOTTO_COUNT)
                .sorted()
                .collect(Collectors.toList())));
        }
        return new Lottos(lottos);
    }

}
