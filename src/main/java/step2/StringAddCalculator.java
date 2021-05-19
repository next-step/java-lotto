package step2;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|;";
    private static final String DELIMITER_PATTERN = "^//(.)\\n";

    public int calculate(String data) {
        if (data == null || data.isEmpty()) {
            return 0;
        }
        return calculate(data,DEFAULT_DELIMITER);
    }

    private int calculate(String data, String delimiter) {
        String[] numbers = data.split(delimiter);
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }


}
