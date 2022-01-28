package stringadder.utils.exception;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    private static final String STANDARD_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String SLASH = "//";


    public static List<String> splitStr(final String input){
        String[] tokens = null;
        if(input.contains(SLASH)) {
            tokens = split(input, tokens);
            return Arrays.stream(tokens).collect(Collectors.toList());
        }
        return Arrays.stream(input.split(STANDARD_DELIMITER)).collect(Collectors.toList());
    }

    private static String[] split(String input, String[] tokens) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            tokens = matcher.group(2).split(customDelimiter);
        }
        return tokens;
    }
}
