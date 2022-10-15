package lotto.generator;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<LottoNumber> generate() {
        List<Integer> numbers = makeLandomNumberRange();
        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.subList(MIN_LOTTO_NUM, MAX_LOTTO_NUM);
        return lottoNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    private List<Integer> makeLandomNumberRange() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
