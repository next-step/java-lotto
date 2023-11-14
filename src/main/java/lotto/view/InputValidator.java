package lotto.view;

public class InputValidator {

    public void validatePurchaseMoney(String purchase, int lottoPrice) {
        long purchaseMoney = validateParseLong(purchase);
        validatePurchaseUnit(purchaseMoney, lottoPrice);
    }

    private long validateParseLong(String purchase) {
        long purchaseMoney;

        try {
            purchaseMoney = Long.parseLong(purchase);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액은 양의 정수만 입력 가능합니다.");
        }

        return purchaseMoney;
    }

    private void validatePurchaseUnit(long purchaseMoney, int lottoPrice) {
        if (purchaseMoney%lottoPrice != 0) {
            throw new IllegalArgumentException("구입 금액은 천원 단위이어야 합니다.");
        }
    }
}
