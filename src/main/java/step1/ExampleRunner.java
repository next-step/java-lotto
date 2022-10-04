package step1;

public class ExampleRunner {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.runOperation("1 + 9 / 4 * 4 - 3");
        System.out.println("result = " + result);
    }
}
