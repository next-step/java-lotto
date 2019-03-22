package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {
    private static List<LottoNumber> baseNumbers() {
        return IntStream.range(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public Lotto generateLotto() {
        List<LottoNumber> baseNumbers = baseNumbers();
        Collections.shuffle(baseNumbers);
        return new Lotto(baseNumbers.subList(BASE_INDEX, Lotto.SIZE_LIMIT));
    }
}
