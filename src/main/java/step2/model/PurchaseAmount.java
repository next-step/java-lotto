package step2.model;

public class PurchaseAmount {
    private int purchaseAmount;

    private static final int MIN_AMOUNT = 1000;
    private static final int LOTTO_PRICE = 1000;

    public PurchaseAmount(String amount) {
        isBlank(amount);
        isDigit(amount);
        isOverMinAmount(amount);
        this.purchaseAmount = Integer.parseInt(amount);
        this.purchaseAmount = calcPurchaseAmount(getLottoCount());
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void isBlank(String amount) {
        if (amount == null || amount.isEmpty()) {
            throw new IllegalArgumentException("빈값입니다.다시 입력해주세요.");
        }
    }

    private void isDigit(String amount) {
        if (!amount.trim().matches("[0-9]*")) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private void isOverMinAmount(String amount) {
        if (Integer.parseInt(amount.trim()) < MIN_AMOUNT) {
            throw new IllegalArgumentException("로또를 사기에 부족한 금액입니다. 1000원이상 입력해주세요.");
        }
    }

    public int getLottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public int calcPurchaseAmount(int lottoCount) {
        return lottoCount * LOTTO_PRICE;
    }
}
