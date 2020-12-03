package step2.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> lotto = new HashSet<>();

    public Lotto(List<LottoNumber> numbers) {
        for (LottoNumber number : numbers) {
            lotto.add(LottoNumber.of(number));
        }

        if (this.lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 값이어야 합니다.");
        }
    }
}
