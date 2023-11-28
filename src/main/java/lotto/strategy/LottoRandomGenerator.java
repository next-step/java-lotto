package lotto.strategy;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomGenerator implements LottoGenerator {

    @Override
    public Lotto generate() {
        List<Integer> numbers = new ArrayList<>();
        for (int number = LottoNumber.MIN_LOTTO_NUMBER; number <= LottoNumber.MAX_LOTTO_NUMBER; number++) {
            numbers.add(number);
        }
        Collections.shuffle(numbers);

        return new Lotto(numbers.subList(0, Lotto.LOTTO_NUMBER_COUNT));
    }

}
