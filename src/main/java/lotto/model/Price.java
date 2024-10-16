package lotto.model;

import java.util.Objects;
import java.util.regex.Pattern;

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

    public void foreach(Runnable runnable) {
        long count = this.price / LOTTO_PRICE;
        for (int i = 0 ; i < count ; i++) {
            runnable.run();
        }
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
