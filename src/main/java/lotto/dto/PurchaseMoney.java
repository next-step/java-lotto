package lotto.dto;

import lotto.exception.OverMinusMoneyRequestException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static lotto.domain.LottoPrice.LOTTO_PRICE;

public class PurchaseMoney {
    private static final String MESSAGE_POSITIVE_NUMBER_ONLY = "구입금액은 양수만 입력할 수 있습니다.";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+(,\\d+)*$");

    private final int amount;
    private int remain;

    public PurchaseMoney(String amount) {
        validateStringConstructor(amount);
        this.amount = parseInt(amount);
        this.remain = this.amount;
    }

    public PurchaseMoney(int amount) {
        validateIntConstructor(amount);
        this.amount = amount;
        this.remain = amount;
    }

    public void minus(ManuallyPurchasingLottoCount manuallyPurchasingLottoCount) {
        if (this.remain < manuallyPurchasingLottoCount.getValue() * LOTTO_PRICE) {
            throw new OverMinusMoneyRequestException();
        }
        this.remain -= manuallyPurchasingLottoCount.getValue() * LOTTO_PRICE;
    }

    private void validateStringConstructor(String value) {
        Matcher numberArrayCheckResult = NUMBER_PATTERN.matcher(value);
        if (!numberArrayCheckResult.find()) {
            throw new IllegalArgumentException(MESSAGE_POSITIVE_NUMBER_ONLY);
        }
    }

    private void validateIntConstructor(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(MESSAGE_POSITIVE_NUMBER_ONLY);
        }
    }

    public int getRemain() {
        return this.remain;
    }

    public double getAmount() {
        return this.amount;
    }
}
