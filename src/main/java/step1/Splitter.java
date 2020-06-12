package step1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {

    private static final String COLON_DELIMITER = ":";
    private static final String COMMA_DELIMITER = ",";
    private static final String DEFAULT_DELIMITER = ",|\\:";

    public String[] split(String text) {
        String delimiter = getDefaultDelimiter(text);
        return text.split(delimiter);
    }

    private String getDefaultDelimiter(String text) {
        if(text.contains(COMMA_DELIMITER) || text.contains(COLON_DELIMITER)) {
            return DEFAULT_DELIMITER;
        }
        throw new RuntimeException(Error.DELIMITER_NOT_EXIST);
    }


    public List<Number> parseNumber(String[] list) {
        return Arrays.stream(list)
                .map(text -> new Number(text))
                .collect(Collectors.toList());
    }
}
