package lotto.model;

import lotto.strategy.NumberGenerateStrategy;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Price {

    private static final Pattern pricePattern = Pattern.compile("^[0-9]+$");
    public static final String PRICE_INIT_EXCEPT_MESSAGE = "양의 정수 하나를 입력해주세요!";
    public static final int LOTTO_PRICE = 1000;
    private long price;

    public Price(String text) {
        this(toInt(text));
    }

    public Price(int price) {
        this.price = price;
    }

    private static int toInt(String text) {
        if (!pricePattern.matcher(text).matches()) {
            throw new IllegalArgumentException(PRICE_INIT_EXCEPT_MESSAGE);
        }
        return Integer.parseInt(text);
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
