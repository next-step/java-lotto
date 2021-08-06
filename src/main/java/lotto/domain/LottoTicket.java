package lotto.domain;

import java.util.*;

public class LottoTicket {
    private List<Integer> lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers.generateNumbers();
    }

    WinAmount getWinAmount(LottoNumbers winNumbers, int bonusNumber) {
        int matchCount = (int) winNumbers.generateNumbers().stream()
                .filter(i -> this.lottoNumbers.contains(i))
                .count();
        return WinAmount.valueOfMatchCount(matchCount, this.lottoNumbers.contains(bonusNumber));
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
