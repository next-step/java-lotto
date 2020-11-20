package lotto.dto;

import lotto.validator.InputValidator;

public class BuyLotto {

    private static final int LOTTO_PRICE = 1_000;

    private final int randomCount;
    private final int manualCount;

    private BuyLotto(int randomCount, int manualCount) {
        this.randomCount = randomCount;
        this.manualCount = manualCount;
    }

    public static BuyLotto of(String amount, String manualCount) {
        InputValidator.validateBuyLotto(amount, manualCount);

        return new BuyLotto((Integer.parseInt(amount) / LOTTO_PRICE) - Integer.parseInt(manualCount),
                            Integer.parseInt(manualCount)
        );
    }

    public int getRandomCount() {
        return this.randomCount;
    }

    public int getManualCount() {
        return this.manualCount;
    }
}
