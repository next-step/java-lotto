package lotto.step2.domain;

import java.util.List;

public class LottoTicket {
    private List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        Validation.isCorrectLottoCount(lottoNumbers);
        Validation.isValidLotto(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public int matchWinningNumber(WinningNumber winningNumber) {
        int matchCount = 0;
        for (LottoNumber num : lottoNumbers) {
            matchCount += isContainNumber(winningNumber, num);
        }

        return matchCount;
    }

    private int isContainNumber(WinningNumber winningNumber, LottoNumber num) {
        if (winningNumber.getWinningNumbers().contains(num)) {
            return 1;
        }
        return 0;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
