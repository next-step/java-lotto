package lotto.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator implements NumberGenerator {
    private static final List<Integer> allLottoNumbers;

    static {
        allLottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(LottoNumber.MIN_BOUND, LottoNumber.MAX_BOUND)
                .boxed()
                .distinct()
                .forEach(allLottoNumbers::add);
    }

    @Override
    public List<Integer> generator() {
        Collections.shuffle(allLottoNumbers);
        return allLottoNumbers.stream()
                .limit(Lotto.NUMBER_SIZE)
                .collect(Collectors.toList());
    }
}
