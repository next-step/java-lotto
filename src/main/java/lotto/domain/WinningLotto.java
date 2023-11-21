package lotto.domain;

import java.util.List;

public class WinningLotto {
    public final Lotto lotto;
    public final LottoNum bonusNum;

    public WinningLotto(List<Integer> nums, int bonusNum) {
        this.lotto = Lotto.of(nums);
        this.bonusNum = new LottoNum(bonusNum);
    }

    public WinningLotto(Lotto lotto, int bonusNum) {
        this.lotto = lotto;
        this.bonusNum = new LottoNum(bonusNum);
    }

    public LottoPrize getPrize(Lotto lotto) {
        int matchCount = (int) lotto.getLottoNums().stream()
                .filter(lottoNum -> this.lotto.getLottoNums().contains(lottoNum))
                .count();
        boolean bonusMatch = lotto.getLottoNums().contains(bonusNum);
        return LottoPrize.valueOf(matchCount, bonusMatch);
    }
}
