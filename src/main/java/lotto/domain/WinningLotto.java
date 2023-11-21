package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNum bonusNum;

    public WinningLotto(List<Integer> nums, int bonusNum) {
        this.lotto = Lotto.of(nums);
        this.bonusNum = new LottoNum(bonusNum);
    }

    public WinningLotto(Lotto lotto, int bonusNum) {
        this.lotto = lotto;
        this.bonusNum = new LottoNum(bonusNum);
    }

    public LottoPrize getPrize(Lotto lotto) {
        int matchCount = lotto.getMatchCount(this.lotto);
        boolean bonusMatch = lotto.match(bonusNum);
        return LottoPrize.valueOf(matchCount, bonusMatch);
    }
}
