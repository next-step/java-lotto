package string_calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PatternRegex {
    public static final String DEFAULT_INPUT_PATTERN = ",|:";
    public static final Pattern CUSTOM_INPUT_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final int PATTERN_FIRST_INDEX = 1;
    public static final int PATTERN_SECOND_INDEX = 2;

    public String[] split(final String str){
        Matcher matcher = CUSTOM_INPUT_PATTERN.matcher(str);

        if(matcher.find()){
            String pattern = matcher.group(PATTERN_FIRST_INDEX);
            return matcher.group(PATTERN_SECOND_INDEX).split(pattern);
        }

        return str.split(DEFAULT_INPUT_PATTERN);
    }


}
