package step2.view.dto;

import step2.domain.PurchaseCount;

public class PurchaseCountDto {

    private final int value;

    public PurchaseCountDto(PurchaseCount purchaseCount) {
        this.value = purchaseCount.getValue();
    }

    @Override
    public String toString() {
        return value + " 개를 구매했습니다.";
    }
}
