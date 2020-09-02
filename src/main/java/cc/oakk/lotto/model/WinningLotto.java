package cc.oakk.lotto.model;

import java.util.List;

import static cc.oakk.lotto.model.Lotto.NUMBER_COUNT;
import static cc.oakk.lotto.util.ValidationAdapters.throwIfNull;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public Rank score(Lotto target) {
        throwIfNull(target);
        long matchingCount = target.getMatchingCount(lotto);
        boolean hasBonus = target.contains(bonusNumber);
        return Rank.getRankByDifferentCount((int) (NUMBER_COUNT - matchingCount), hasBonus);
    }
}
