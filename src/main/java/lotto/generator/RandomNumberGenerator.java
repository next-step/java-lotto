package lotto.generator;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<LottoNumber> generate() {
        List<Integer> numbers = makeLandomNumberRange();
        Collections.shuffle(numbers);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUM; i < MAX_LOTTO_NUM; i++) {
            lottoNumbers.add(LottoNumber.from(numbers.get(i)));
        }
        return lottoNumbers;
    }

    private List<Integer> makeLandomNumberRange() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
