package lotto.domain;

public class Lotto {

    static final String regularExpression = "^[0-9]+$";

    public Boolean integerValidation(String amount){
        return amount.matches(regularExpression);
    }

}
