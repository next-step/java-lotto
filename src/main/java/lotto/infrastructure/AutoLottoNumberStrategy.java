package lotto.infrastructure;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static lotto.domain.Constant.*;

public class AutoLottoNumberStrategy implements LottoNumberStrategy {
    private final List<Integer> lottoNumbers;

    public AutoLottoNumberStrategy() {
        this.lottoNumbers = IntStream.rangeClosed(LOTTO_NUM_MIN, LOTTO_NUM_MAX)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public LottoNumber get() {
        Collections.shuffle(lottoNumbers);
        List<Integer> selectedNumbers = lottoNumbers.subList(ZERO_INDEX, LOTTO_NUM_COUNT_LIMIT);
        selectedNumbers.sort(comparingInt(Integer::intValue));

        return new LottoNumber(selectedNumbers);
    }
}
