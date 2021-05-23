package stringAddCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Divider {
    private final String CUSTOM_DELIMITER = "//(.)\n(.*)";


    List<String> getSplitByCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if(matcher.find()){
            return Arrays.asList(matcher.group(1),matcher.group(2));
        }
        return Arrays.asList(input);
    }

}
