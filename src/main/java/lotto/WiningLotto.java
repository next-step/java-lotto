package lotto;

import java.util.Set;

public class WiningLotto {

    public static final int BONUS_BOUNDARY_VALUE = 5;
    private final Lotto winningLotto;
    private final LottoNumber bonus;

    public WiningLotto(Set<Integer> numbers, int bonus) {
        this(new Lotto(numbers), new LottoNumber(bonus));
    }

    public WiningLotto(Lotto winningLotto, LottoNumber bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public MatchedCount countMatchedNumber(Lotto lotto) {
        MatchedCount matchedCount = this.winningLotto.countMatchedNumber(lotto);
        if (!matchedCount.isEquals(BONUS_BOUNDARY_VALUE)) {
            return matchedCount;
        }
        boolean contains = lotto.contains(bonus);
        return new MatchedCount(BONUS_BOUNDARY_VALUE, contains);
    }
}
