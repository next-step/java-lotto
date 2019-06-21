package camp.nextstep.edu.calculator;

public class StringAdditionCalculator {

    public int calculate(String input) {
        if (input == null) {
            return 0;
        }
        if ("".equals(input)) {
            return 0;
        }
        return Integer.parseInt(input);
    }

}
