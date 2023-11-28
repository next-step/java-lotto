package step4.domain.lotto;

import java.util.Objects;
import java.util.Set;

public class UserLotto {

    private final static int LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    public UserLotto(final Set<LottoNumber> lottoNumbers) {
        checkValidationNumberCount(lottoNumbers.size());
        this.lottoNumbers = lottoNumbers;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int findCountOfMatch(final WinningLotto winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> winningLotto.hasLottoNumber(lottoNumber))
                .count();
    }

    public boolean hasBonusNumber(final WinningLotto winningLotto) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> winningLotto.hasBonusNumber(lottoNumber));
    }

    private static void checkValidationNumberCount(final int count) {
        if (count != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLotto userLotto = (UserLotto) o;
        return Objects.equals(lottoNumbers, userLotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "UserLotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
