package splitter;

public class CommaSplitter {

    private static final String COMMA = ",";

    public String[] split(final String value) {
        return value.split(COMMA);
    }
}
