package step1.calculator;

import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * .
 */
public class EtcSplitString implements SplitString {
    @Override
    public String[] split(String input) {
        return (input.length() == 1) ? singleString(input) : customString(input);
    }

    private String[] singleString(String inputString) {
        return new String[]{inputString};
    }

    private String[] customString(String inputString) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        throw new InvalidParameterException("올바른 구분자를 입력하세요");
    }
}
