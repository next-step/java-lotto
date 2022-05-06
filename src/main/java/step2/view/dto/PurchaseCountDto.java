package step2.view.dto;

import step2.domain.PurchaseMoney;

public class PurchaseCountDto {

    private final int value;

    public PurchaseCountDto(PurchaseMoney purchaseMoney) {
        this.value = purchaseMoney.getPurchaseCount();
    }

    @Override
    public String toString() {
        return value + " 개를 구매했습니다.";
    }
}
