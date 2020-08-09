package lotto.domain;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class LottoShop {

    private static final int DEFAULT_PRICE_UNIT = 1000;
    private static final String PRICE_ERROR_MESSAGE = "price must be at least zero";
    private static final String PRICE_UNIT_MESSAGE = "price {0} won unit";

    public static List<Lotto> buyAuto(int purchasePrice) {
        checkArgument(purchasePrice > 0, PRICE_ERROR_MESSAGE);
        checkArgument(purchasePrice % DEFAULT_PRICE_UNIT == 0,
            MessageFormat.format(PRICE_UNIT_MESSAGE, DEFAULT_PRICE_UNIT));

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchasePrice / DEFAULT_PRICE_UNIT; i++) {
            lottos.add(Lotto.generateAuto());
        }

        return lottos;
    }

}
