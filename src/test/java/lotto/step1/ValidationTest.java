package lotto.step1;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    @Test
    void test() {
        String text = "//;\n1;2;3";
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
        System.out.println(matcher.find());
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
    }

}