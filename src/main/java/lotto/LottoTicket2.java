package lotto;

import java.util.Set;

public class LottoTicket2 {

    private Set<LottoNumber> lottoNumbers;

    public LottoTicket2(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public long matchNumbers(Set<LottoNumber> lastWeekWinningNumbers) {
        return lastWeekWinningNumbers.stream()
              .filter(lottoNumber -> lottoNumbers.contains(lottoNumber))
              .count();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}