package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isEmpty(text)) return 0;

        String[] nums = text.split(",|:");
        return sum(nums);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.trim().length() == 0;
    }

    private static int sum(String[] nums) {
        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
