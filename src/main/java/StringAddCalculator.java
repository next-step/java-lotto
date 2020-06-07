public class StringAddCalculator {
    public static int splitAndSum(String calcStr) {
        int result = 0;

        if (calcStr == null || calcStr.isEmpty()) {
            return 0;
        }

        String[] numbers = calcStr.split(",");
        for (String number: numbers) {
            result += Integer.parseInt(number);
        }

        return result;
    }
}
