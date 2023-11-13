package lotto.domain.strategy;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManualLottoNumberStrategy implements LottoNumberStrategy {

    private static final String COMMA_BLANK = ", ";

    private final List<LottoNumber> numbers;

    public ManualLottoNumberStrategy(String input) {
        List<LottoNumber> numbers = new ArrayList<>();
        for (String number : input.split(COMMA_BLANK)) {
            numbers.add(LottoNumber.valueOf(number));
        }
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    @Override
    public List<LottoNumber> create() {
        return this.numbers;
    }

}
