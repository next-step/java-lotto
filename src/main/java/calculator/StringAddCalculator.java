package calculator;

public class StringAddCalculator {

    public int calculate(String input) {
        int result = 0;
        if (input.isEmpty() || input == null) {
            return 0;
        }

        if(input.length() == 1){
            return Integer.parseInt(input);
        }

        return result;
    }
}
