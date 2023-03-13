package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest {


    @Test
    void matcherTest() {

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher("//;\n");

        if (m.find()) {
            Assertions.assertEquals(m.group(1), ";");
        }


    }
}
