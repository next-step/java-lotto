package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WinnerNumbers {
    private final int NUMBER_OF_NUMBERS = 6;

    private final Set<Number> numbers;
    private final Number bonus;

    public WinnerNumbers(Set<Number> numbers, Number bonus) {
        validate(numbers);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validate(Set<Number> numbers) {
        if (numbers.size() != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException("당첨번호의 갯수는 6개 입니다.");
        }
    }

    public int match(Set<Number> lottoNumbers) {
        List<Number> numbers = new ArrayList<>(this.numbers);
        numbers.retainAll(lottoNumbers);
        return numbers.size();
    }

    public boolean hasBonus(Set<Number> lottoNumbers) {
        return lottoNumbers.contains(bonus);
    }
}
