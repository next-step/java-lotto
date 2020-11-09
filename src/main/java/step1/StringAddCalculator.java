package step1;

public class StringAddCalculator {
    private StringAddCalculator () {}

    public static int splitAndSum(String input) {
        if (Validator.checkZero(input)) {
            return 0;
        }
        if (Validator.checkSingle(input)) {
            return Parser.parseNumStr(input);
        }
        return Calculator.calcSum(input);
    }
}
