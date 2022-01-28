package stringadder.utils.exception;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    private static final String DELIMITER = ",|:";

    public static List<String> splitStr(final String input){
        return Arrays.stream(input.split(DELIMITER)).collect(Collectors.toList());
    }
}
