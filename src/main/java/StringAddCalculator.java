public class StringAddCalculator {
    public static int splitAndSum(String text) {
        int sum = 0;
        String[] numbers = text.split(",|:");

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
