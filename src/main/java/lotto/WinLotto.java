package lotto;

import java.util.List;
import java.util.Objects;

public class WinLotto {
    private final Lotto lotto;
    private final LottoNumber bonus;

    /*
        CONSTRUCTOR
     */
    public WinLotto(List<Integer> lottoNumberList, Integer bonusNumber) {
        this(new Lotto(lottoNumberList), LottoNumber.of(bonusNumber));
    }

    public WinLotto(Lotto lotto, LottoNumber bonus) {
        validateDuplicate(lotto, bonus);

        this.lotto = lotto;
        this.bonus = bonus;
    }

    /*
        FUNCTION
     */
    private void validateDuplicate(Lotto lotto, LottoNumber bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException("유효하지 않은 보너스 번호입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinLotto winLotto = (WinLotto) o;
        return Objects.equals(lotto, winLotto.lotto) && Objects.equals(bonus, winLotto.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonus);
    }
}
