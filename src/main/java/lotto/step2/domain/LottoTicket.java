package lotto.step2.domain;

import java.util.List;

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
    public String toString() {
        return lottoNumbers.toString();
    }
}
