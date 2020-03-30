public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return sum(toInt(split(input)));
    }

    private static int[] toInt(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            int number = Integer.parseInt(values[i]);
            if (number < 0 ) {
                throw new RuntimeException("입력에 음수가 포함될 수 없습니다.");
            }

            numbers[i] = number;
        }
        return numbers;
    }

    private static String[] split(String input) {
        return input.split(",|:");
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }
}
