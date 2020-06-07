public class StringAddCalculator {
    public static int splitAndSum(String calcStr) {
        int result = -99;

        if (calcStr == null || calcStr.isEmpty()) {
            return 0;
        }

        if (calcStr.length() == 1) {
            return Integer.parseInt(calcStr);
        }

        String[] numbers = calcStr.split(",");
        int sum = 0;
        for (String number: numbers) {
            sum += Integer.parseInt(number);
        }

        result = sum;

        return result;
    }
}
