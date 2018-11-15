package util;

public class Validation {

    public static void validatePurchaseMoney(int money){
        if(money < 0)
            throw new RuntimeException("구입금액이 올바르게 입력되지 않았습니다.");
    }

    public static void validatePurchaseAmount(int amount){
        if(amount < 0)
            throw new RuntimeException("로또 수가 올바르게 입력되지 않았습니다.");
    }

}
