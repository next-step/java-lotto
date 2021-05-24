package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.MAXIMUM_NUMBER;
import static lotto.domain.LottoNumber.MINIMUM_NUMBER;
import static lotto.domain.LottoNumbers.LOTTO_NUMBERS_LENGTH;

public class RandomLottoNumbersGenerator implements NumbersGenerator {

    private static final List<Integer> LOTTO_NUMBERS_CANDIDATES = IntStream.range(MINIMUM_NUMBER, MAXIMUM_NUMBER).boxed().collect(Collectors.toList());

    @Override
    public List<LottoNumbers> generate(int count) {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Collections.shuffle(LOTTO_NUMBERS_CANDIDATES);
            lottoNumbersList.add(LottoNumbers.of(LOTTO_NUMBERS_CANDIDATES.stream().limit(LOTTO_NUMBERS_LENGTH).collect(Collectors.toList())));
        }
        return lottoNumbersList;

    }
}
