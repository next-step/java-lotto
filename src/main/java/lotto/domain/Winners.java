package lotto.domain;

import java.util.Objects;

public class Winners {

    private final LottoNumbers winNumbers;
    private final LottoNumber bonusNumber;

    public Winners(LottoNumbers winNumbers, LottoNumber bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Statistics match(Orders orders) {
        Statistics statistics = new Statistics();

        orders.getOrders().stream()
                .map(lotto -> WinningRule.match(this.winNumbers, lotto.getNumbers(), this.bonusNumber))
                .filter(Objects::nonNull)
                .forEach(n -> statistics.put(n, statistics.get(n) + 1));

        return statistics;
    }

}
