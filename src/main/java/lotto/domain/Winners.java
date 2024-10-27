package lotto.domain;

public class Winners {

    private final LottoNumbers winNumbers;

    public Winners(String text) {
        this(new LottoNumbers(text));
    }

    public Winners(LottoNumbers winNumbers) {
        this.winNumbers = winNumbers;
    }

    public Statistics match(Orders orders) {
        Statistics statistics = new Statistics();

        orders.getOrders().stream()
                .map(this::match)
                .filter(n -> n >= 3)
                .forEach(n -> statistics.put(n, statistics.get(n) + 1));

        return statistics;
    }

    private int match(Lotto lotto) {
        return this.winNumbers.match(lotto.getNumbers());
    }
}
