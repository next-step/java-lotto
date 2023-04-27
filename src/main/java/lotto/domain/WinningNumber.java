package lotto.domain;

import java.util.List;
import java.util.Map;

public class WinningNumber {

    private LottoNumber winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        this.winningNumber = new LottoNumber(winningNumber);
    }

    public Map<LottoRank, Integer> countMatching(LottoNumbers lottoNumbers) {
        return lottoNumbers.calculateSameNumberCounts(winningNumber);
    }
}
