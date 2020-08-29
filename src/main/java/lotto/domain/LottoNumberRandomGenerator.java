package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;

public class LottoNumberRandomGenerator implements LottoNumberGenerator {
    private static final List<LottoNumber> randomLottoNumbers;

    static {
        randomLottoNumbers = IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    @Override
    public Set<LottoNumber> generator(int count) {
        shuffleRandomLottoNumber();
        return randomLottoNumbers.stream()
                .limit(count)
                .collect(Collectors.toSet());
    }

    private void shuffleRandomLottoNumber() {
        Collections.shuffle(randomLottoNumbers);
    }
}
