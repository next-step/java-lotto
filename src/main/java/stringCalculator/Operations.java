package stringCalculator;

public class Operations {
    public static int operationSum(String[] numbers) {
        int sum = 0;
        for (String number: numbers) {
            sum += strToInt(number);
        }

        return sum;
    }

    public static int strToInt(String calcStr) throws RuntimeException {
        try {
            int num = Integer.parseInt(calcStr);
            if (num < 0) {
                throw new RuntimeException();
            }

            return num;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
