package step2.domain;

import java.util.Objects;

public class PurchasePrice {

    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자만 입력해 주세요";

    private final int purchasePrice;

    public PurchasePrice(String purchasePrice) {
        this.purchasePrice = validationInteger(purchasePrice);
    }

    private int validationInteger(String purchasePrice) {
        try {
            return Integer.parseInt(purchasePrice);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchasePrice that = (PurchasePrice) o;
        return purchasePrice == that.purchasePrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchasePrice);
    }
}
