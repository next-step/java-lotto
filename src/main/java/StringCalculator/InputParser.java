package StringCalculator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    public static List<String> parseStringToStringList(String input) {
        if (input == null || "".equals(input)) {
            return Collections.singletonList("0");
        }

        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher m = pattern.matcher(input);
        if(m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return Arrays.asList(tokens);
        }

        return Arrays.asList(input.split("[,:]"));
    }
}
