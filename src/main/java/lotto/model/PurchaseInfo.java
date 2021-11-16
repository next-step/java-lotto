package lotto.model;

public class PurchaseInfo {

    private final int amount;

    public PurchaseInfo(int amount){
        checkValidation(amount);
        this.amount = amount;
    }

    private void checkValidation(int amount) {
        if(amount < 0) throw new IllegalArgumentException("구매액은 음수일 수 없습니다.");
    }

}
