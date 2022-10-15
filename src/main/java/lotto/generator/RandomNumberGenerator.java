package lotto.generator;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<LottoNumber> generate() {
        List<Integer> numbers = makeNumberRange();
        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.subList(MIN_LOTTO_NUM_COUNT, MAX_LOTTO_NUM_COUNT);
        return lottoNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    private List<Integer> makeNumberRange() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
