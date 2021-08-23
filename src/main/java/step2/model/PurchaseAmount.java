package step2.model;

import java.util.Objects;

import static step2.model.LottoValidator.*;

public class PurchaseAmount {
    private int purchaseAmount;

    private static final int MIN_AMOUNT = 1000;
    private static final int LOTTO_PRICE = 1000;

    public PurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public PurchaseAmount(String amount) {
        isBlank(amount);
        isDigit(amount);
        isOverMinAmount(amount);
        this.purchaseAmount = changeToInt(amount);
        this.purchaseAmount = calcLottoAmount(getLottoCount());
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void isOverMinAmount(String amount) {
        if (changeToInt(amount) < MIN_AMOUNT) {
            throw new IllegalArgumentException("로또를 사기에 부족한 금액입니다. 1000원이상 입력해주세요.");
        }
    }

    public int getLottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    private int calcLottoAmount(int lottoCount) {
        return lottoCount * LOTTO_PRICE;
    }

    public PurchaseAmount calcPurchaseAmount(String lottoCount) {
        isBlank(lottoCount);
        isDigit(lottoCount);
        int amount = calcLottoAmount(changeToInt(lottoCount));
        if (amount > purchaseAmount) {
            throw new IllegalArgumentException("구매할 로또수를 다시 확인해주세요. 금액이 부족합니다.");
        }

        return new PurchaseAmount(purchaseAmount - amount);
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
