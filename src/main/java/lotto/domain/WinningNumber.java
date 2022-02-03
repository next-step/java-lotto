package lotto.domain;

import java.util.List;
import lotto.domain.lotto.LottoNumber;

public class WinningNumber {
    private final List<LottoNumber> numbers;
    private final LottoNumber bonus;

    public WinningNumber(List<LottoNumber> numbers, LottoNumber bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers;
    }

    public LottoNumber getBonus() {
        return this.bonus;
    }
}
