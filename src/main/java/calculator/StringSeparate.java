package calculator;

import java.util.regex.Pattern;

@FunctionalInterface
public interface StringSeparate {
    SplitNumber split(Pattern pattern, String separateStr);
}
