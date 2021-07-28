package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final Set<LottoNumber> values;

    public Lotto(Set<LottoNumber> numbers) {
        this.values = numbers;
    }
}
