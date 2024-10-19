package lotto.model;

import lotto.strategy.NumberGenerateStrategy;
import lotto.util.Utils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Price {

    public static final int LOTTO_PRICE = 1000;
    private long price;

    public Price(String text) {
        this(Utils.stringToLong(text));
    }

    public Price(long price) {
        this.price = price;
    }

    public Lottos generateLottos(NumberGenerateStrategy numberGenerateStrategy) {
        int count = (int) this.price / LOTTO_PRICE;

        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(numberGenerateStrategy.generateNumber()))
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public double calculateRateOfProfit(long profit) {
        return (double) profit / this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price);
    }
}
