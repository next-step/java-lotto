package util;

public class Validation {

    public static void validatePurchaseAmount(int amount){
        if(amount < 0)
            throw new RuntimeException();
    }
}
