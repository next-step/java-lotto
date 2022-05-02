package lotto;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static lotto.Const.LOTTERY_PRICE;

public class Money {
    public final int price;
    public Money(int price) {
        if (price < LOTTERY_PRICE) {
            throw new IllegalArgumentException("Please give more than 1000 won. but: " + price);
        }
        this.price = price;
    }
}
