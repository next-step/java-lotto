package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoGenerator {
    private static final List<LottoNumber> BASE_NUMBERS;

    static {
        BASE_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private AutoLottoGenerator() {}

    public static Lottos tickets(int amount) {
        final List<Lotto> lottos = IntStream.range(0, amount)
                .mapToObj(idx -> ticket())
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public static Lotto ticket() {
        return new Lotto(shuffledList()
                .subList(0, Lotto.NUMBER_LENGTH)
                .stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    private static List<LottoNumber> shuffledList() {
        final List<LottoNumber> shuffleTarget = new ArrayList<>(BASE_NUMBERS);
        Collections.shuffle(shuffleTarget);
        return shuffleTarget;
    }

}
