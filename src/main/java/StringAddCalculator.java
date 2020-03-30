public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return sum(split(input));
    }

    private static String[] split(String input) {
        return input.split(",|:");
    }

    private static int sum(String[] strings) {
        int sum = 0;
        for (String num : strings) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
