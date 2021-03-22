package Calculator;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (StringUtils.checkEmpty(input)) {
            return 0;
        }
        int[] operands = StringUtils.parseOperand(input.split(""));
        return operands[0];
    }
}
