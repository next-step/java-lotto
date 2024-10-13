package lotto.domain;

import java.util.Collections;
import java.util.Set;

public class Lotto {

    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        validateLottoSize(numbers);
        LottoNumbers.validate(numbers);
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }

    public void validateLottoSize(Set<Integer> numbers) {
        if (numbers.size() != LottoCreateStrategy.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 " + LottoCreateStrategy.LOTTO_SIZE + "개여야 합니다.");
        }
    }
}
