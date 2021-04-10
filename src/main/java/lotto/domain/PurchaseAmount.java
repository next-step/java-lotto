package lotto.domain;

import java.util.Objects;

import static lotto.utils.ConvertUtil.toInt;

public class PurchaseAmount {
    private final static int PURCHASE_AMOUNT_MIN = 1_000;
    private final static String GREATER_THAN_MIN = String.format("구매금액은 최소 %d원 이상이여야 합니다.", PURCHASE_AMOUNT_MIN);
    private final static String CHECK_PURCHASE_AMOUNT = "입력하신 금액 %s가 숫자인지 확인해주세요.";
    private final int purchaseAmount;

    public PurchaseAmount(String purchaseAmount) {
        this(toInt(CHECK_PURCHASE_AMOUNT, purchaseAmount));
    }

    public PurchaseAmount(int purchaseAmount) {
        checkGreaterThanMinimum(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int purchaseAmount() {
        return purchaseAmount;
    }

    public int dividedBy(LottoTicketPrice lottoTicketPrice) {
        return lottoTicketPrice.divide(purchaseAmount);
    }

    public int dividedBy(int lottoTicketPrice) {
        return dividedBy(new LottoTicketPrice(lottoTicketPrice));
    }

    public double divide(int totalPrize) {
        return (double) totalPrize / purchaseAmount;
    }

    private void checkGreaterThanMinimum(int purchaseAmount) {
        if (purchaseAmount < PURCHASE_AMOUNT_MIN) {
            throw new IllegalArgumentException(GREATER_THAN_MIN);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseAmount that = (PurchaseAmount) o;
        return purchaseAmount == that.purchaseAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseAmount);
    }
}
