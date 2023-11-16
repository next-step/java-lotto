package lotto.domain;

import java.util.List;

public class WinningLotto {
    public Lotto lotto;

    public WinningLotto(List<Integer> nums) {
        this.lotto = Lotto.of(nums);
    }

    public int matchCount(Lotto lotto) {
        int matchCount = 0;
        for (int num : lotto.getNums()) {
            if (this.lotto.getNums().contains(num)) {
                matchCount++;
            }
        }
        return matchCount;
    }

}
