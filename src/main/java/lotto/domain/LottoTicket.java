package lotto.domain;

import java.util.Set;

class LottoTicket {
    private Set<LottoNumber> lottoNumbers;

    LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers.generateNumbers();
    }

    public WinAmount getWinAmount(LottoNumbers winNumbers) {
        int matchCount = (int) winNumbers.generateNumbers().stream()
                .filter(i -> this.lottoNumbers.contains(i))
                .count();
        return WinAmount.valueOfMatchCount(matchCount);
    }
}
