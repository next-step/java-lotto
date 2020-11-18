package lotto.dto;

public class PurchaseMoneyDto {
    private final int purchaseMoney;

    public PurchaseMoneyDto(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }
}
