package study.step2;

public class StringAddCalculator {
    private static final StringCalculator calc = new StringCalculator();

    public static int splitAndSum(String text) {
        return calc.sum(text);
    }
}
