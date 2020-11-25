package study.lotto.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 당첨된 로또
 */
public class WinningLotto {

    private final LottoRank lottoRank;
    private List<LottoNumber> matchingNumbers;

    public WinningLotto(List<LottoNumber> matchingNumbers, boolean matchBonusLottoNumber) {
        this.matchingNumbers = Optional.ofNullable(matchingNumbers)
                .orElse(new ArrayList<>());
        this.lottoRank = LottoRank.of(this, matchBonusLottoNumber);
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
