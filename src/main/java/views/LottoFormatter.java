package views;

import step2.domain.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.Set;

public class LottoFormatter {

    private final Set<LottoNumber> numbers;

    public LottoFormatter(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public String numbersAsListString() {
        return new ArrayList<>(numbers).toString();
    }
}
