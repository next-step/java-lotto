package lotto.domain;

import java.text.MessageFormat;
import java.util.function.Supplier;

import static com.google.common.base.Preconditions.checkArgument;

public class LottoShop {

    public static final int DEFAULT_PRICE_UNIT = 1000;

    private static final String PRICE_ERROR_MESSAGE = "price must be at least zero";
    private static final String PRICE_UNIT_MESSAGE = "price {0} won unit";
    private static final String NOT_ENOUGH_MONEY_MESSAGE = "There is not enough money";
    private static final String COUNT_ERROR_MESSAGE = "count must be at least zero";

    private final int purchasePrice;
    private final Lottos lottos;
    private int manualCount = 0;

    public LottoShop(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        lottos = new Lottos();
    }

    public static LottoShop purchasePrice(int purchasePrice) {
        checkArgument(purchasePrice > 0, PRICE_ERROR_MESSAGE);
        checkArgument(purchasePrice % DEFAULT_PRICE_UNIT == 0,
                MessageFormat.format(PRICE_UNIT_MESSAGE, DEFAULT_PRICE_UNIT));
        return new LottoShop(purchasePrice);
    }

    public LottoShop buyAuto() {
        if (canBuyLotto()) {
            lottos.generateAuto(canBuyLottoCount() - manualCount);
        }
        return this;
    }

    public LottoShop buyManual(int count, Supplier<Lotto> lottoSupplier) {
        checkArgument(count >= 0, COUNT_ERROR_MESSAGE);
        checkArgument(lottoPrice(count) <= purchasePrice, NOT_ENOUGH_MONEY_MESSAGE);
        checkArgument(canBuyLotto(), NOT_ENOUGH_MONEY_MESSAGE);

        for (int i = 0; i < count; i++) {
            lottos.add(lottoSupplier.get());
        }
        manualCount = count;
        return this;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public int getAutoCount() {
        return lottos.size() - manualCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    private boolean canBuyLotto() {
        return lottoPrice(lottos.size()) < purchasePrice;
    }

    private int lottoPrice(int count) {
        return count * DEFAULT_PRICE_UNIT;
    }

    private int canBuyLottoCount() {
        return purchasePrice / DEFAULT_PRICE_UNIT;
    }
}
