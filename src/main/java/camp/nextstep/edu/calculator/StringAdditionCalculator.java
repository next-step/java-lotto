package camp.nextstep.edu.calculator;

public class StringAdditionCalculator {

    private static final String EMPTY_STRING = "";
    private static final int ZERO = 0;

    public int calculate(String input) {
        if (input == null) {
            return ZERO;
        }
        if (EMPTY_STRING.equals(input)) {
            return ZERO;
        }
        return Integer.parseInt(input);
    }

}
