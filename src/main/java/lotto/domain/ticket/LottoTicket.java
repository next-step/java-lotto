package lotto.domain.ticket;

import java.util.List;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int findMatchCount(String[] winningNumbers) {
        return (int) lottoNumbers.stream()
                                 .filter(lottoNumber -> lottoNumber.isContain(winningNumbers))
                                 .count();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
