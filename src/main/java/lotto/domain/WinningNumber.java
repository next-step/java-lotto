package lotto.domain;

import java.util.List;
import java.util.Map;

public class WinningNumber {

    private LottoNumber winningNumber;
    private int bonusNumber;


    public WinningNumber(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = new LottoNumber(winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public Map<LottoRank, Integer> countMatching(LottoNumbers lottoNumbers) {
        return lottoNumbers.calculateSameNumberCounts(winningNumber, bonusNumber);
    }
}
