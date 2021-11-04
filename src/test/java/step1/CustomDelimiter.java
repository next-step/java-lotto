package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter {

    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    private final String item;

    public CustomDelimiter(String item) {
        this.item = item;
    }

    public boolean isExist() {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(this.item);
        return matcher.find();
    }
}
