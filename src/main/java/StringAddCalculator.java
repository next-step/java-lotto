import exception.NegativeException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {

    private static final String DEFAULT_SEPARATOR = ",|:";

    public static int splitAndSum(String value){
        if(value == null || value.isEmpty()){
            return 0;
        }

        int[] list = split(value);
        return sum(list);

    }

    private static int[] split(String value){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(value);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return Stream.of(m
                .group(2)
                .split(customDelimiter)).mapToInt(Integer::parseInt).toArray();
        }
        return Stream.of(
            value
            .split(DEFAULT_SEPARATOR))
            .mapToInt(Integer::parseInt)
            .toArray();
    }

    private static int sum(int[] list) {
        for (int i : list){
            if(i < 0) throw new NegativeException("음수는 입력 할 수 없습니다.");
        }
        return Arrays.stream(list).sum();
    }
}
