import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String PATTERN_END = "\n";
    private static final String PATTERN_START = "//";
    private static String CUSTOM_DELIMITER = "[,:]";


    public static int splitAndSum(String inputData) {
        int result = 0;
        String[] splitInputData;

        if (checkNullInputData(inputData)) {
            return result;
        }

        Matcher matcher = Pattern.compile(PATTERN_START + "(.)" + PATTERN_END + "(.*)").matcher(inputData);

        if (matcher.find()) {
            CUSTOM_DELIMITER = matcher.group(1);
            inputData = matcher.group(2);
        }

        splitInputData = inputData.split(CUSTOM_DELIMITER);

        for (String splitData : splitInputData) {
            checkMinus(splitData);
            result = result + getParseInt(splitData);
        }

        return result;
    }

    private static void checkMinus(String splitInputData) {
        if (getParseInt(splitInputData) < 0) {
            throw new RuntimeException();
        }
    }

    private static boolean checkNullInputData(String inputData) {
        return inputData == null || inputData.isEmpty();
    }

    private static int getParseInt(String splitInputData) {
        return Integer.parseInt(splitInputData);
    }
}
