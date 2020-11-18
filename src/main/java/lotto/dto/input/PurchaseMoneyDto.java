package lotto.dto.input;

public class PurchaseMoneyDto {
    private final int purchaseMoney;

    public PurchaseMoneyDto(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }
}
