package calculator;

public class MultiplicationCalculate implements CalculateStrategy {

    private static final String SEPARATOR = "*";

    @Override
    public boolean support(String separator) {
        return separator.equals(SEPARATOR);
    }

    @Override
    public void calculate(final Number number, final String target) {
        number.multiplication(target);
    }
}
