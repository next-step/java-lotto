import exception.NegativeException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {

    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String SEPARATOR_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String value){
        if(value == null || value.isEmpty()){
            return 0;
        }

        int[] numbers = split(value);
        return sum(numbers);
    }

    private static int[] split(String value){
        Matcher m = Pattern.compile(SEPARATOR_REGEX).matcher(value);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return convertStringToIntArray(m.group(2)
                .split(customDelimiter));
        }
        return convertStringToIntArray(value.split(DEFAULT_SEPARATOR));
    }

    private static int[] convertStringToIntArray(String[] list){
        return Stream
            .of(list)
            .mapToInt(Integer::parseInt)
            .toArray();
    }

    private static int sum(int[] list) {
        validateNegativeNumber(list);
        return Arrays.stream(list).sum();
    }

    private static void validateNegativeNumber(int[] list) {
        Arrays.stream(list).filter(i -> i < 0).forEach(i -> {
            throw new NegativeException("음수는 입력 할 수 없습니다.");
        });
    }
}
