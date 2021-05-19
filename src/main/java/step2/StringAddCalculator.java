package step2;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|;";
    public int calculate(String data, String delimiter) {
        String[] numbers = data.split(delimiter);
        int result = 0;
        for(String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }

    public int calculate(String data) {
        return calculate(data,DEFAULT_DELIMITER);
    }
}
