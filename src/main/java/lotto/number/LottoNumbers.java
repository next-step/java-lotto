package lotto.number;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    public static final int NUMBERS_LENGTH = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        isValid(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getValue() {
        return this.lottoNumbers;
    }

    private void isValid(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException("로또 숫자는 6개입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers lottoNumbers1 = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, lottoNumbers1.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    public int countWinningNumbers(WinningNumbers winningNumbers) {
        return (int) winningNumbers.getValue().stream().filter(this.lottoNumbers::contains).count();
    }
}
