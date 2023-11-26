package step4.domain.lotto;

import java.util.Objects;
import java.util.Set;

public class WinningLotto {

    private final static int LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(final Set<LottoNumber> lottoNumbers, final LottoNumber bonusNumber) {
        checkValidationNumberCount(lottoNumbers.size());
        checkDuplicatedWinningNumbers(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private static void checkValidationNumberCount(final int count) {
        if (count != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private static void checkDuplicatedWinningNumbers(final Set<LottoNumber> lottoNumbers, final LottoNumber bonusNumber) {
        lottoNumbers.stream().filter(lottoNumber -> lottoNumber.equals(bonusNumber))
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복일 수 없습니다.");
                });
    }

    public boolean hasLottoNumber(final LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public boolean hasBonusNumber(final LottoNumber lottoNumber) {
        return this.bonusNumber.equals(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, bonusNumber);
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "lottoNumbers=" + lottoNumbers +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}
