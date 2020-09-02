package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringCalculator {


    public static int splitAndSum(String val)  {

        if(val == null) {
            return 0;
        }

        if(val.isEmpty()) {
            return 0;
        }

        IntStream stream = split(val);
        isValidate(stream);

        return stream.sum();
    }


    public static IntStream split(String val) {
        IntStream intOfInputStream = null;

        Matcher m = Pattern.compile("//(.)\\n(.*)").matcher(val);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] inputs = m.group(2).split(customDelimiter);

            intOfInputStream = Arrays.stream(inputs).mapToInt(value -> Integer.parseInt(value));

            return intOfInputStream;
        }

        String[] inputs = val.split(",|:");
        intOfInputStream = Arrays.stream(inputs).mapToInt(value -> Integer.parseInt(value));

        return intOfInputStream;
    }


    public static void isValidate(IntStream stream) throws RuntimeException {
        stream.filter( value -> value < 0)
                .findAny()
                .ifPresent( value -> new RuntimeException() );
    }
}
