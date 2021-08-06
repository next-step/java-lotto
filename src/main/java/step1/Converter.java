package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {


    private static final String customSeparatorRegExp = "//(.)\n(.*)";

    public String[] parseNumber(String textValue) {

        String[] stringNumbers = new String[0];
        String separate = ",|:";

        if (Pattern.matches(customSeparatorRegExp, textValue)) {
            Matcher m = Pattern.compile(customSeparatorRegExp).matcher(textValue);

            if (m.find()) {
                separate = m.group(1);
                stringNumbers = m.group(2).split(separate);
            }
            return stringNumbers;

        }

        stringNumbers = textValue.split(separate);

        return stringNumbers;
    }
}
