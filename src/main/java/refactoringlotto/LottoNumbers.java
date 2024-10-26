package refactoringlotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    public static final int RANK_SUB_NUMBER = 7;
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers(List<Integer> lottoWinningList) {
        for (int winningNumber : lottoWinningList) {
            lottoNumbers.add(new LottoNumber(winningNumber));
        }
        checkSize();
    }

    private void checkSize() {
        if (lottoNumbers.size()!=6) {
            throw new IllegalArgumentException();
        }
    }

    public int lottoRank(List<LottoNumber> lottoNumbers) {
        return RANK_SUB_NUMBER - (int) lottoNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }
}
