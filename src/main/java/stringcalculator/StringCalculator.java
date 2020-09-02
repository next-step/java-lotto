package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringCalculator {


    public static int splitAndSum(String val) throws RuntimeException {
        int result = 0;

        if(val == null) {
            return 0;
        }

        if(val.isEmpty()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\\n(.*)").matcher(val);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] inputs = m.group(2).split(customDelimiter);


            IntStream intOfInputStream = Arrays.stream(inputs).mapToInt(value -> Integer.parseInt(value));

            intOfInputStream.filter( value -> value < 0)
                            .findAny()
                            .ifPresent( value -> new RuntimeException("음수는 입력할 수 없습니다.") );

            result = intOfInputStream.sum();
            return result;
        }

        String[] inputs = val.split(",|:");
        IntStream intOfInputStream = Arrays.stream(inputs).mapToInt(value -> Integer.parseInt(value));

        intOfInputStream.filter( value -> value < 0)
                .findAny()
                .ifPresent( value -> new RuntimeException("음수는 입력할 수 없습니다.") );

        result = intOfInputStream.sum();

        return result;
    }
}
