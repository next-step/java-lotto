package lotto.domain;

import java.util.List;

public class WinningLotto {
    public Lotto lotto;

    public WinningLotto(List<Integer> nums) {
        this.lotto = Lotto.of(nums);
    }

    public LottoPrize getPrize(Lotto lotto) {
        int matchCount = (int) lotto.getLottoNums().stream()
                .filter(lottoNum -> this.lotto.getLottoNums().contains(lottoNum))
                .count();

        return LottoPrize.valueOf(matchCount);
    }

}
