package Step1;

import java.util.Arrays;
import java.util.List;

public class StringConverter {
    private static final String REGEX = " ";

    public List<String> convertToList(String mathEquation) {
        return Arrays.asList(mathEquation.split(REGEX));
    }

}
