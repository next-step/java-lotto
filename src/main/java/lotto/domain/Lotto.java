package lotto.domain;

public class Lotto {

    static final String regularExpression = "^[0-9]+$";
    Boolean integerValidation(String amount){
        return amount.matches(regularExpression);
    }

    public int lottoQuantity(String amount) {
        if (integerValidation(amount)) {
            return Integer.valueOf(amount) / 1000;
        }
        return 0;
    }
}
