package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottos {

    public static final List<LottoNumber> NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
            .mapToObj(LottoNumber::of)
            .collect(Collectors.toList());

    public static List<Lotto> createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(generateNumbers()));
        }
        return lottos;
    }

    private static Set<LottoNumber> generateNumbers() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.stream()
                .limit(Lotto.LOTTO_NUMBERS_SIZE)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
