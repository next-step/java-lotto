import java.util.Arrays;
import java.util.List;

public enum Delimiter {

    COMMA(",", "comma"),
    COLON(":", "colon");

    Delimiter(String delimiter, String desc) {
        this.delimiter = delimiter;
        this.desc = desc;
    }

    private final static String DELIMITERS = ",|:";

    private final String delimiter;
    private final String desc;

    public String getDelimiter() {
        return delimiter;
    }

    public static final List<Delimiter> BASIC_DELIMITER = Arrays.asList(COMMA, COLON);

    public boolean hasBasicDelimiter() {
        return BASIC_DELIMITER.contains(this);
    }

    public static String[] split(String input) {
        return input.split(DELIMITERS);
    }

    public boolean hasDelimiter(String input) {
        return input.contains(this.getDelimiter());
    }

}
