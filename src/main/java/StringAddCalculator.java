import static java.lang.Integer.parseInt;

public class StringAddCalculator {


    public static int calculator(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (checkOneNumber(input)) {
            return Integer.parseInt(input);
        }

        return splitAndSum(input);
    }

    private static boolean checkOneNumber(String input) {
        String[] numbers = input.split("");
        int size = numbers.length;
        return size == 1;
    }

    private static int splitAndSum(String input) {
        String[] numbers = input.split(",|:");
        int sum = 0;
        int size = numbers.length;
        for (String aNumber : numbers) {
            sum += Integer.parseInt(aNumber);
        }

        return sum;
    }

}
