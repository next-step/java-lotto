package lotto.step1;

public class StringAddCalculator {

    private final Calculator calculator;

    public StringAddCalculator(String calculator) {
        this.calculator = new Calculator(calculator);
    }

    public int splitAndSum() {
       if (calculator.checkEmptyAndNull()) {
           return 0;
       }

       if (calculator.checkNotNegativeNumber()) {
           return calculator.printNumber();
       }

       return calculator.calculate();
    }
}
