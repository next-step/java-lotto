package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final List<LottoNumber> lottoNumber;

    static {
        lottoNumber = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public static Lotto lottoGenerator(Shuffle suffle) {
        return suffle.suffle(lottoNumber);
    }

    public static List<Lotto> lottoBundle(List<Lotto> lottos, int count, Shuffle suffle) {

        for (int idx = 0; idx < count; idx++) {
            lottos.add(LottoGenerator.lottoGenerator(suffle));
        }

        return lottos;
    }

}
