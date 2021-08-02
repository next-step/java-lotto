package lotto.step1;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String DELIMITER = ",|:";
    @Test
    void nullCheck() {
        String text = "//.\n1.2.3";
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
        System.out.println(matcher.find());
        String group1 = matcher.group(1);
        System.out.println(group1);
        String group2 = matcher.group(2);
        System.out.println(group2);

    }
}