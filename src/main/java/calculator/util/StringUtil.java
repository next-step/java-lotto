package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringUtil {
    private static final Pattern PATTERN = Pattern.compile("^[0-9-+/*\\s]*$");

    public boolean isNullOrEmpty(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("이름이 Null 혹은 빈문자열 입니다.");
        }
        return false;
    }

    public boolean isRightString(String string) {
        if (!PATTERN.matcher(string).matches()) {
            throw new IllegalArgumentException("올바르지 않은 입력값 입니다.");
        }
        return true;
    }

    public List<String> splitString(String s) {
        return Arrays.asList(s.split(" "));
    }

}
