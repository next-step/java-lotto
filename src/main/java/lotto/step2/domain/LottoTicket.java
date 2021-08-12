package lotto.step2.domain;

import java.util.List;
import java.util.Objects;

public class LottoTicket {
    private List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        Validation.isCorrectLottoCount(lottoNumbers);
        Validation.isValidLotto(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public int matchWinningNumber(LottoTicket winningNumber) {
        int matchCount = 0;
        for (LottoNumber num : lottoNumbers) {
            matchCount += isContainNumber(winningNumber, num);
        }

        return matchCount;
    }

    private int isContainNumber(LottoTicket winningNumber, LottoNumber num) {
        if (winningNumber.getLottoNumbers().contains(num)) {
            return 1;
        }
        return 0;
    }

    public static LottoTicket generateWinningNumber(List<LottoNumber> winningNumbers) {
        return new LottoTicket(winningNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
