public class StringCalculator {

    public int calculate(String equation) {
        String[] operands = equation.split(":|,");

        int result = 0;
        for (String operand : operands) {
            result += convertToInt(operand);
        }

        return result;
    }

    private int convertToInt(String operand) {
        int converted = Integer.parseInt(operand);

        checkValidInput(converted);

        return converted;
    }

    private void checkValidInput(int input) {
        if (input < 0) {
            throw new RuntimeException();
        }
    }
}