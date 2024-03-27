package lotto.domain;

import lotto.exception.InvalidPurchaseAmountOfMoneyException;

import java.math.BigDecimal;

import static java.math.RoundingMode.DOWN;

public class PurchaseAmountOfMoney {
    private static final int LOTTO_PRICE = 1000;

    private final int amountOfMoney;

    private PurchaseAmountOfMoney(int amountOfMoney) {
        validateAmountOfMoney(amountOfMoney);
        this.amountOfMoney = amountOfMoney;
    }

    private void validateAmountOfMoney(int amountOfMoney) {
        if (amountOfMoney < LOTTO_PRICE) {
            throw new InvalidPurchaseAmountOfMoneyException(String.valueOf(amountOfMoney));
        }
    }

    public static PurchaseAmountOfMoney valueOf(int amountOfMoney) {
        return new PurchaseAmountOfMoney(amountOfMoney);
    }

    public int totalNumberOfLottoToPurchase() {
        return amountOfMoney / LOTTO_PRICE;
    }

    public double rateOfReturn(int totalWinningMoney) {
        double realUsedAmountOfMoney = (amountOfMoney - (amountOfMoney % LOTTO_PRICE));
        BigDecimal rateOfReturn = BigDecimal.valueOf(totalWinningMoney / realUsedAmountOfMoney);
        return rateOfReturn.setScale(2, DOWN).doubleValue();
    }
}
