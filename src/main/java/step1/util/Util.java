package step1.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public String numberValid(String value) {
        if (value == null || value.equals("")) {
            return "0";
        }
        return value;
    }

    public void isNegative(String value) {
        Pattern pattern = Pattern.compile("-(?:[0-9])");
        Matcher matcher = pattern.matcher(value);

        if (matcher.find()) {
            throw new RuntimeException("입력값이 음수입니다.");
        }
    }
}
