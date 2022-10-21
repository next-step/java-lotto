package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WinnerNumbers {
    private final Set<Number> numbers;
    private final Number bonus;

    public WinnerNumbers(Set<Number> numbers, Number bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }
    
    public Rank checkRank(Set<Number> lottoNumbers) {
        return Rank.valueOf(match(lottoNumbers), lottoNumbers.contains(bonus));
    }

    private int match(Set<Number> lottoNumbers) {
        List<Number> numbers = new ArrayList<>(this.numbers);
        numbers.retainAll(lottoNumbers);
        return numbers.size();
    }
}
