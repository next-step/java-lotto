package lotto.strategy;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;

import java.util.HashSet;
import java.util.Set;

import static lotto.model.LottoNumber.LOTTO_MAX_RANGE;
import static lotto.model.LottoNumber.LOTTO_MIN_RANGE;
import static lotto.model.LottoNumbers.LOTTO_MAX_COUNT;

public class RandomLotto implements LottoStrategy{

    @Override
    public LottoNumbers generateSixNumber() {
        Set<LottoNumber> numbers = new HashSet<>();
        while (numbers.size() != LOTTO_MAX_COUNT) {
            int randomNumber = generateRandomNumber();
            numbers.add(LottoNumber.of(randomNumber));
        }
        return new LottoNumbers(numbers);
    }
    private int generateRandomNumber(){
        return LottoNumber.of((int) (Math.random() * LOTTO_MAX_RANGE + LOTTO_MIN_RANGE))
                .number();
    }

}
