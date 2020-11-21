public class StringAddCalculator {
    public static int splitAndSum(String input) {
        // 널, 빈 문자열 체크
        if (input == null || input.isEmpty()) {
            return 0;
        }
        // 스플릿
        String[] numbers = split(input);
        // 더하기
        return sum(numbers);
    }

    private static String[] split(String input) {
        return input.split(",|:");
    }

    private static int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
