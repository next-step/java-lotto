package lotto.domain;

import java.util.InputMismatchException;

public class PurchaseQuantity {

    private final int quantity;
    public PurchaseQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int find(){
        return quantity;
    }

    public PurchaseQuantity diff(PurchaseQuantity manualPurchase) {
        if(isImpossible(manualPurchase)){
            throw new InputMismatchException("구매한 수량에 맞게 갯수를 생성하여 주세요");
        }
        return new PurchaseQuantity(quantity-manualPurchase.find());
    }

    private boolean isImpossible(PurchaseQuantity manualPurchase) {
        return quantity < manualPurchase.find();
    }
}
