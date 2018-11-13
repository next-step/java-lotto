package stringCalculator;

public class StringCalculator {

    public static int add(String source) {
        if (source == null || source.isEmpty()) {
            return 0;
        }

        if (source.contains(",")) {
            int result = 0;
            for (String value : source.split(",")) {
                result += Integer.parseInt(value);
            }
            return result;
        }

        return Integer.parseInt(source);
    }
}
