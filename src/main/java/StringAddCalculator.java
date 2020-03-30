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

    private static int sum(String[] values) {
        int sum = 0;
        for (String value : values) {
            int number = Integer.parseInt(value);
            if (number < 0 ) {
                throw new RuntimeException("입력에 음수가 포함될 수 없습니다.");
            }

            sum += number;
        }

        return sum;
    }
}
