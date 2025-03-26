package step2.domain;

import java.util.Iterator;
import java.util.Set;

public class Lotto {
    private final Set<LottoNum> lotto;

    public Lotto(Set<LottoNum> lotto) {
        this.lotto = lotto;
        valid(lotto);
    }

    public int isSameCount(Set<LottoNum> winningNums) {
        Iterator<LottoNum> lotto = this.lotto.iterator();
        int count = 0;
        for (int i = 0; i < this.lotto.size(); i++) {
            if (winningNums.contains(lotto.next())) {
                count++;
            }
        }
        return count;
    }

    private void valid(Set<LottoNum> nums) {
        if (nums.size() != 6) {
            throw new IllegalArgumentException("로또의 숫자 개수는 6개여야 합니다.");
        }
    }
}
