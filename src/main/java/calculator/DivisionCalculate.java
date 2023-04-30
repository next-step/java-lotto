package calculator;

public class DivisionCalculate implements CalculateStrategy {

    private static final String SEPARATOR = "/";

    @Override
    public boolean support(final String separator) {
        return separator.equals(SEPARATOR);
    }

    @Override
    public void calculate(final Number number, final String target) {
        number.division(target);
    }
}
