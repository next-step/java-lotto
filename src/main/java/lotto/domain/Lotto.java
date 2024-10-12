package lotto.domain;

import java.util.Collections;
import java.util.Set;

public class Lotto {

    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        LottoMachine.validateLottoSize(numbers);
        LottoNumbers.validate(numbers);
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }
}
