package study.lotto.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 당첨된 로또
 */
public class WinningLotto {

    private final LottoRank lottoRank;
    private List<LottoNumber> matchingNumbers = new ArrayList<>();

    public WinningLotto(List<LottoNumber> matchingNumbers) {
        this.matchingNumbers = matchingNumbers;
        this.lottoRank = LottoRank.of(this);
    }

    public int getMatchingNumberCount() {
        return this.matchingNumbers.size();
    }

    public LottoRank getLottoRank() {
        return lottoRank;
    }

    public int getPrize() {
        return lottoRank.getPrizeAmount();
    }
}
