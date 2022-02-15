package stringcalculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Delimiters {

    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";
    private static final int DEFAULT_DELIMITER_SIZE = 2;
    private static final int DELIMITER_STRING_INDEX = 0;

    private List<Delimiter> delimiters;

    public Delimiters(final String inputDelimiters) {
        final List<String> delimiters = getDelimiters(inputDelimiters);

        this.delimiters = delimiters.stream()
                .map(Delimiter::new)
                .collect(Collectors.toList());
    }

    private List<String> getDelimiters(final String inputDelimiters) {
        if (isBlank(inputDelimiters)) {
            return Arrays.asList(DEFAULT_DELIMITER_COLON, DEFAULT_DELIMITER_COMMA);
        }
        return Collections.singletonList(inputDelimiters);
    }

    private boolean isBlank(final String inputDelimiters) {
        return inputDelimiters.isEmpty();
    }

    public String getValuesToRegex() {
        if(delimiters.size() == DEFAULT_DELIMITER_SIZE){
            String delimiters = this.delimiters.stream()
                    .map(Delimiter::getValue)
                    .collect(Collectors.joining(""));
            return String.format("[%s]", delimiters);
        }
        return delimiters.get(DELIMITER_STRING_INDEX).getValue();
    }
}
