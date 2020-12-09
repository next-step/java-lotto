package step3.domain;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> lotto = new LinkedHashSet<>();

    public Lotto(List<LottoNumber> numbers) {
        for (LottoNumber lottoNumber : numbers) {
            lotto.add(LottoNumber.of(lottoNumber.getNumber()));
        }

        if (this.lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 값이어야 합니다.");
        }
    }

    public int match(Lotto winningLotto) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : winningLotto.getLotto()) {
            matchCount += lotto.contains(lottoNumber) ? 1 : 0;
        }
        return matchCount;
    }

    public Set<LottoNumber> getLotto() {
        return this.lotto;
    }
}
