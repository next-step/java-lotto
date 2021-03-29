package lotto.generator;

import lotto.constants.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator implements NumberGenerator {
    private static final List<Integer> allLottoNumbers;

    static {
        allLottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(Constants.LOTTO_MIN_BOUND, Constants.LOTTO_MAX_BOUND)
                .boxed()
                .distinct()
                .forEach(allLottoNumbers::add);
    }

    @Override
    public List<Integer> generator() {
        Collections.shuffle(allLottoNumbers);
        return allLottoNumbers.stream()
                .limit(Constants.LOTTO_SIZE)
                .collect(Collectors.toList());
    }
}
