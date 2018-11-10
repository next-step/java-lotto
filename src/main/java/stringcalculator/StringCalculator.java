package stringcalculator;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String str) throws Exception {

        if (isNull(str)) {
            return 0;
        }

        if (isCustomInput(str)) {
            checkPositiveNumber(splitCustomInput(str));
            return getResult(splitCustomInput(str));
        }

        checkPositiveNumber(splitInput(str));
        return getResult(splitInput(str));
    }

    private static boolean isCustomInput(String str) {
        return Pattern.compile("//(.)\n(.*)").matcher(str).find();
    }

    private static boolean isNull(String str) {
        return str == null || str == "";
    }

    private static void checkPositiveNumber(String [] values) throws Exception {
        for(int i = 0; i < values.length; i++) {
            isNotPositiveNumber(values[i]);
        }
    }

    private static void isNotPositiveNumber(String value) throws Exception {
        if(!NumberUtils.isNumber(value) || Integer.parseInt(value) < 0)
           throw new Exception();
    }

    private static String[] splitCustomInput(String str) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);

        if(m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return null;
    }

    private static String[] splitInput(String str) {
        return str.split("[,:]");
    }

    private static int getResult(String[] values) {
        int result = 0;

        for(int i = 0; i < values.length; i++) {
            result += Integer.parseInt(values[i]);
        }
        return result;
    }
}
