package step3.domain;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> lotto = new LinkedHashSet<>();

    public Lotto(List<LottoNumber> numbers) {
        for (LottoNumber lottoNumber : numbers) {
            lotto.add(LottoNumber.of(lottoNumber.getNumber()));
        }

        validateLottoSize();
    }

    private void validateLottoSize() {
        if (this.lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 값이어야 합니다.");
        }
    }

    public Set<LottoNumber> getLotto() {
        return this.lotto;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lotto.contains(lottoNumber);
    }
}
