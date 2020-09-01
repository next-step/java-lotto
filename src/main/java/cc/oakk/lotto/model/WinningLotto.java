package cc.oakk.lotto.model;

import java.util.List;

import static cc.oakk.lotto.model.Lotto.NUMBER_COUNT;
import static cc.oakk.lotto.util.ValidationAdapters.throwIfNull;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public Rank score(Lotto target) {
        throwIfNull(target);
        int matchingCount = (int) lotto.get().stream()
                .filter(target.get()::contains)
                .count();

        boolean hasBonus = target.get().stream().anyMatch(v -> v.equals(bonusNumber));
        return Rank.getRankByDifferentCount(NUMBER_COUNT - matchingCount, hasBonus);
    }
}
