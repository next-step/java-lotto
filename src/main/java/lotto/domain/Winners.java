package lotto.domain;

import java.util.Objects;

public class Winners {

    private final LottoNumbers winNumbers;
    private final LottoNumber bonusNumber;

    public Winners(String text) {
        this(new LottoNumbers(text));
    }

    public Winners(LottoNumbers winNumbers) {
        this(winNumbers, null);
    }

    public Winners(LottoNumbers winNumbers, LottoNumber bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Statistics match(Orders orders) {
        Statistics statistics = new Statistics();

        orders.getOrders().stream()
                .map(this::matchWinningRule)
                .filter(Objects::nonNull)
                .forEach(n -> statistics.put(n, statistics.get(n) + 1));

        return statistics;
    }

    private WinningRule matchWinningRule(Lotto lotto) {
        WinningRule totalMatch = WinningRule.match(this.winNumbers, lotto.getNumbers());
        if (totalMatch == WinningRule.FIVE) {
            return getTotalMatchWithBonus(lotto, totalMatch);
        }
        return totalMatch;
    }

    private WinningRule getTotalMatchWithBonus(Lotto lotto, WinningRule totalMatch) {
        LottoNumber lottoNumber = this.winNumbers.notMatchedNumbers(lotto.getNumbers()).get(0);
        if (lottoNumber.equals(this.bonusNumber)) {
            return WinningRule.FIVE_BONUS;
        }
        return totalMatch;
    }
}
