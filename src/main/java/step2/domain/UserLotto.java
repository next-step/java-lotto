package step2.domain;

import java.util.List;
import java.util.Objects;

public class UserLotto extends Lotto {

    public UserLotto(List<Integer> lottoNumbers) {
        super(lottoNumbers);
    }

    public Prize getPrize(WinningLotto winningLotto) {
        int hitCount;
        boolean isMatchedBonus = false;

        hitCount = (int) getLottoNumbers().stream()
            .filter(number -> winningLotto.getLottoNumbers().contains(number)).count();

        if (getLottoNumbers().contains(winningLotto.getBonusNumber())) {
            isMatchedBonus = true;
        }

        return Prize.valueOf(hitCount, isMatchedBonus);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottoNumbers());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserLotto lotto = (UserLotto) o;
        return Objects.equals(getLottoNumbers(), lotto.getLottoNumbers());
    }
}
