package step1;

public class StringAddCalculator {

    public static int calculate(String expression) {
        int ans = 0;
        String[] numbers = expression.split(":|,");
        for (String number : numbers) {
            ans += Integer.parseInt(number);
        }
        return ans;
    }
}
