package step2.domain.enums;

import java.util.function.Function;

public enum WinnerPriceEnum {
    MATCH_3(winCount -> winCount * 5000, 5000, 3),
    MATCH_4(winCount -> winCount * 50000, 50000, 4),
    MATCH_5(winCount -> winCount * 1500000, 1500000, 5),
    MATCH_6(winCount -> winCount * 2000000000, 2000000000, 6);

    private Function<Integer, Integer> expression;
    public int price;
    public int matchCount;

    WinnerPriceEnum(Function<Integer, Integer> expression, int price, int matchCount) {
        this.expression = expression;
        this.price = price;
        this.matchCount = matchCount;
    }

    public int calculatePrice(int winCount) {
        return expression.apply(winCount);
    }
}
