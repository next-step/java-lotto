package lotto.domain.lotto;

import java.util.List;

public class Ticket {

    private final LottoNumbers lotto;

    public Ticket(final LottoNumbers numbers) {
        this.lotto = numbers;
    }

    public LottoNumbers getLotto() {
        return lotto;
    }

    public int matches(final List<LottoNumber> comparison) {
        return lotto.countMatches(comparison);
    }

    public boolean hasBonus(final int bonus) {
        return lotto.hasBonus(new LottoNumber(bonus));
    }
}
