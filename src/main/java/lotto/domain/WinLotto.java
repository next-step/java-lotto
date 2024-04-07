package lotto.domain;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class WinLotto{

    private Lotto winLotto;
    private LottoNumber bonus;

    public WinLotto(Set<Integer> lottoNumbers, Integer bonus) {
        this.winLotto = new Lotto(getLottoNumbers(lottoNumbers));
        this.bonus = new LottoNumber(bonus);
    }

    private static Set<LottoNumber> getLottoNumbers(Set<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public int getFeatNumberCount(Lotto lotto) {
        return (int) lotto.getLotto().stream()
            .filter(value -> winLotto.getLotto().contains(value))
            .count();
    }

    public boolean isContainBonus(Lotto lotto) {
        return lotto.isContainBonus(bonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        WinLotto winLotto = (WinLotto) o;
        return Objects.equals(bonus, winLotto.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }
}
