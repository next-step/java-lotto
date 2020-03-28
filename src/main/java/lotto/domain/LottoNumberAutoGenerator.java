package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static lotto.domain.Constant.*;

public class LottoNumberAutoGenerator {
    private final List<Integer> lottoNumbers;

    LottoNumberAutoGenerator() {
        this.lottoNumbers = IntStream.rangeClosed(LOTTO_NUM_MIN, LOTTO_NUM_MAX)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> get() {
        Collections.shuffle(lottoNumbers);
        List<Integer> selectedNumbers = lottoNumbers.subList(ZERO_INDEX, LOTTO_NUM_COUNT_LIMIT);
        selectedNumbers.sort(comparingInt(Integer::intValue));
        return selectedNumbers;
    }
}
