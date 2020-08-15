package lotto.domain;

import java.text.MessageFormat;

import static com.google.common.base.Preconditions.checkArgument;

public class LottoShop {

    public static final int DEFAULT_PRICE_UNIT = 1000;

    private static final String PRICE_ERROR_MESSAGE = "price must be at least zero";
    private static final String PRICE_UNIT_MESSAGE = "price {0} won unit";
    private static final String COUNT_ERROR_MESSAGE = "count must be at least zero";
    private static final String NOT_ENOUGH_MONEY_MESSAGE = "there is not enough money";

    public static Lottos purchase(int price, int manualCount) {
        checkArgument(price > 0, PRICE_ERROR_MESSAGE);
        checkArgument(price % DEFAULT_PRICE_UNIT == 0,
                MessageFormat.format(PRICE_UNIT_MESSAGE, DEFAULT_PRICE_UNIT));
        checkArgument(manualCount >= 0, COUNT_ERROR_MESSAGE);

        int canPurchaseCount = canPurchaseCount(price);
        checkArgument(canPurchaseCount >= manualCount, NOT_ENOUGH_MONEY_MESSAGE);

        return new Lottos(canPurchaseCount(price));
    }

    public static int canPurchaseCount(int price) {
        return price / DEFAULT_PRICE_UNIT;
    }
}
