package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.trim().length() == 0) {
            return 0;
        }

        String[] nums = text.split(",|:");

        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
