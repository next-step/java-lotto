package calculator.domain;

public abstract class AbstractTwoNumbersCalculator implements TwoNumbersCalculator{

    protected final Integer num1;
    protected final Integer num2;

    public AbstractTwoNumbersCalculator(Integer num1, Integer num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

}
