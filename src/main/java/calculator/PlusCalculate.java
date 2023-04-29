package calculator;

public class PlusCalculate implements CalculateStrategy {

    private static final String SEPARATOR = "+";

    @Override
    public boolean support(final String separator) {
        return separator.equals(SEPARATOR);
    }

    @Override
    public void calculate(final Number number, final String target) {
        number.plus(target);
    }
}
