package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinLotto extends Lotto {

    private LottoNumber bonus;

    public WinLotto(List<Integer> lottoNumbers, Integer bonus) {
        this(lottoNumbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
        this.bonus = new LottoNumber(bonus);
    }

    private WinLotto(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public int getFeatNumberCount(Lotto lotto) {
        return (int) lotto.getLotto().stream()
            .filter(value -> super.getLotto().contains(value))
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
