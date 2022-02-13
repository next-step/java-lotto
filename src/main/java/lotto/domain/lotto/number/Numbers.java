package lotto.domain.lotto.number;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.util.NumbersValidator;

public class Numbers {

    private final List<Number> numbersValue;

    public Numbers(final String input) {
        this(NumbersValidator.validate(input));
    }

    public Numbers(final Numbers newNumbers) {
        this(newNumbers.getNumbersValue());
    }

    public Numbers(final List<Number> numbers) {
        this.numbersValue = new ArrayList<>(numbers);
    }

    public List<Number> getNumbersValue() {
        return new ArrayList<>(numbersValue);
    }

    public boolean has(Number number) {
        return numbersValue.contains(number);
    }

    public Integer getMatchCount(Lotto lotto) {
        return Math.toIntExact(this.numbersValue.stream().filter(lotto::hasNumber).count());
    }
}
