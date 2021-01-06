package lotto.domain;

import util.ValidateUtils;

public class LottoCount {
    private static final String VALID_EMPTY_MESSAGE = "금액을 다시 입력해주세요";
    private static final String VALID_NUMBER_MESSAGE = "숫자만 입력해주세요.";
    private static final String VALID_PURCHASE_UNIT_MESSAGE = "로또 구매 단위는 1000원입니다.";
    private static final String VALID_RANGE_OUT_OF_MANUAL_COUNT_MESSAGE = "수동으로 구매 가능한 로또 수를 초과하였습니다.";

    private static final int MIN_PRICE = 1000;
    private static final int MOD_ZERO = 0;

    private int count;
    private int manualCount;

    public LottoCount(String price) {
        validate(price);
    }

    public LottoCount(String price, String manualCount) {
        this(price);
        validateRange(parseNumber(manualCount));

    }

    public boolean isManualCount() {
        return manualCount > 0;
    }

    private void validateRange(int manualCount) {
        if (manualCount < 0 || manualCount > count) {
            throw new IllegalArgumentException(VALID_RANGE_OUT_OF_MANUAL_COUNT_MESSAGE);
        }
        this.manualCount = manualCount;
    }

    private void validate(String price) {
        validateEmpty(price);
        validateNumber(price);
    }

    private void validateEmpty(String price) {
        if (ValidateUtils.isEmpty(price)) {
            throw new IllegalArgumentException(VALID_EMPTY_MESSAGE);
        }
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALID_NUMBER_MESSAGE);
        }
    }

    private void validateNumber(String price) {
        int lottoPrice = parseNumber(price);
        validatePurchasingUnit(lottoPrice);
        this.count = lottoPrice / MIN_PRICE;
    }

    private void validatePurchasingUnit(int price) {
        if (isNotPurchasingUnit(price)) {
            throw new IllegalArgumentException(VALID_PURCHASE_UNIT_MESSAGE);
        }
    }

    private boolean isNotPurchasingUnit(int price) {
        return (price < MIN_PRICE) || (price % MIN_PRICE != MOD_ZERO);
    }

    public int autoCount() {
        return count - manualCount;
    }

    public int count() {
        return count;
    }

    public int manualCount() {
        return manualCount;
    }
}
