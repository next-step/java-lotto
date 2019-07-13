package lotto;

import java.util.Set;

public class LottoAuto implements Lotto {
    private Set<LottoNumber> lotto;

    public LottoAuto(Set<LottoNumber> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException();
        }
        this.lotto = lotto;
    }

    @Override
    public Set<LottoNumber> getLotto() {
        return lotto;
    }

    @Override
    public int match(Lotto winningLotto) {
        return (int) this.lotto.stream()
                .filter(winningLotto::contains)
                .count();
    }

    @Override
    public boolean contains(LottoNumber lottoNumber) {
        return this.lotto.contains(lottoNumber);
    }
}
