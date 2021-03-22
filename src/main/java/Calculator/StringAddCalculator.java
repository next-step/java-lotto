package Calculator;

public class StringAddCalculator {

    private static final int INIT_NUM = 0;



    public static int splitAndSum(String input) {
        if (StringUtils.checkEmpty(input)) {
            return INIT_NUM;
        }
        int[] operands = StringUtils.parseOperand(input.split(",|:"));
        return Operator.add(operands);
    }
}
