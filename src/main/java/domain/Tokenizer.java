package domain;

import java.util.Arrays;
import java.util.List;

public class Tokenizer {

    static final String BLANK_DELIMITER = " ";

    public static List<String> splitToken(String stringLine) {
        return Arrays.
                asList(stringLine.split(BLANK_DELIMITER));
    }

}
