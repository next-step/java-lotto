import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringNumbers {

    private static final int PATTERN_DELIMITER_NUMBER = 1;
    private static final int PATTERN_NUMBER = 2;
    private static final String PATTERN_DELIMITER_CUSTOM = "//(.)\\n(.*)";
    private static final String PATTERN_DELIMITER_DEFAULT = ",|;";
    private String stringNumber;
    private Matcher customPattern;


    public StringNumbers(String stringNumber) {
        this.stringNumber = nullOrEmptyConvert(stringNumber);
    }


    private String nullOrEmptyConvert(String stringNumber) {
        if (stringNumber == null || stringNumber.trim().isEmpty()) {
            return "0";
        }
        return stringNumber;
    }


    public int sumExecute() {
        customPattern = Pattern.compile(PATTERN_DELIMITER_CUSTOM).matcher(stringNumber);
        if (customPattern.find()) {
            String customDelimiter = customPattern.group(PATTERN_DELIMITER_NUMBER);
            List <String> numbers = Arrays.asList(customPattern.group(PATTERN_NUMBER).split(customDelimiter));
            return patternSum(numbers);
        }

        List <String> numbers = Arrays.asList(stringNumber.split(PATTERN_DELIMITER_DEFAULT));
        return patternSum(numbers);
    }


    private int patternSum(List <String> numbers) {
        int sumNumber = 0;
        for (String number : numbers) {
            sumNumber += new Number(number).getNumber();
        }
        return sumNumber;
    }

}
