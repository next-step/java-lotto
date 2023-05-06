package study.lotto.step2.domain;

public class LottoPurchase {
    private static final long LOTTO_PRICE = 1_000L;
    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";
    private final long purchaseAmount;

    public LottoPurchase(String purchaseAmount) {
        this(valueOf(purchaseAmount));
    }

    public LottoPurchase(long purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public long purchaseSize() {
        return purchaseAmount / LOTTO_PRICE;
    }

    private void validatePurchaseAmount(long purchaseAmount) {
        if(purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("최소 구입 금액은 " + LOTTO_PRICE + "원입니다: " + purchaseAmount);
        }
    }

    private static Long valueOf(String purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return Long.valueOf(purchaseAmount);
    }

    private static void validatePurchaseAmount(String purchaseAmount) {
        if(!isIntegerExpression(purchaseAmount)) {
            throw new IllegalArgumentException("구입 금액은 양의 정수로 입력해야 합니다: " + purchaseAmount);
        }
    }

    private static boolean isIntegerExpression(String purchaseAmount) {
        return purchaseAmount != null && purchaseAmount.matches(POSITIVE_INTEGER_REGEX);
    }
}
