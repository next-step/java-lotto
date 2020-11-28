package step4.domain;

public class Amount {

    private static final int MIN_LOTTO_PRICE = 1000;
    private static final int MAX_LOTTO_PRICE = 100000;

    private final int lottoAmount;

    private Amount(int lottoAmount) {
        this.lottoAmount = lottoAmount;
    }

    public static Amount of(int lottoAmount) {
        purchaseAmountValidate(lottoAmount);
        return new Amount(lottoAmount);
    }
    public int lottoPurchaseQty() {
        return this.lottoAmount / MIN_LOTTO_PRICE;
    }

    private static void purchaseAmountValidate(int lottoAmount) {
        if (lottoAmount == 0) {
            throw new IllegalArgumentException("구입 금액 값이 없습니다.");
        }

        if (lottoAmount < MIN_LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액은 1000원부터 입력가능합니다.");
        }

        if (lottoAmount > MAX_LOTTO_PRICE) {
            throw new IllegalArgumentException("로또는 10만원 이상 구매불가합니다.");
        }
    }
}
