package step3.domain;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> lotto = new LinkedHashSet<>();

    public Lotto(List<LottoNumber> numbers) {
        validateLottoSize(numbers);

        for (LottoNumber lottoNumber : numbers) {
            lotto.add(LottoNumber.of(lottoNumber.getNumber()));
        }
    }

    private void validateLottoSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 값이어야 합니다.");
        }
    }

    public Set<LottoNumber> getLotto() {
        return Collections.unmodifiableSet(this.lotto);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lotto.contains(lottoNumber);
    }
}
