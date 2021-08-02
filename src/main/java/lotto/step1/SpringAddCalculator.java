package lotto.step1;

public class SpringAddCalculator {

    private Validation validation;

    public SpringAddCalculator(String value) {
        this.validation = new Validation(value);
    }

    public int splitAndSum(String text) {
       if (validation.checkEmptyAndNull()) {
           return 0;
       }

       if (validation.checkNotNegativeNumber()) {
           return Integer.valueOf(text);
       }
    }
}
