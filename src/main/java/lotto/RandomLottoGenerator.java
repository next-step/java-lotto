package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator extends LottoGenerator {
    private static List<LottoNumber> baseNumbers =
            IntStream.range(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
                    .mapToObj(LottoNumber::valueOf)
                    .collect(Collectors.toList());

    private RandomLottoGenerator() {
    }

    public static RandomLottoGenerator getInstance() {
        return new RandomLottoGenerator();
    }

    public Lotto generateLotto() {
        Collections.shuffle(baseNumbers);
        return new Lotto(new HashSet<>(baseNumbers.subList(BASE_INDEX, Lotto.SIZE_LIMIT)));
    }
}
