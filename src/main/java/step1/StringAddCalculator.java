package step1;

public class StringAddCalculator {

    public static int calculate(String expression) {
        int ans = 0;
        if (expression == null || expression.isEmpty()) {
            return ans;
        }
        String[] numbers = expression.split(":|,");
        for (String number : numbers) {
            int cur = Integer.parseInt(number);
            if (cur < 0) {
                throw new RuntimeException("입력 숫자는 0보다 작을 수 없습니다.");
            }
            ans += cur;
        }
        return ans;
    }
}
