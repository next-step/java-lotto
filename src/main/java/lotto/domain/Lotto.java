package lotto.domain;

import java.util.Collections;
import java.util.Set;

public class Lotto {

    private final Set<LottoNo> numbers;

    public Lotto(Set<LottoNo> numbers) {
        validateLottoSize(numbers);
        LottoNumbers.validate(numbers);
        this.numbers = numbers;
    }

    public Set<LottoNo> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }

    public void validateLottoSize(Set<LottoNo> numbers) {
        if (numbers.size() != LottoCreateStrategy.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 " + LottoCreateStrategy.LOTTO_SIZE + "개여야 합니다.");
        }
    }
}
