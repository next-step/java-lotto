package splitter;

public class CommaSplitter {

    private static final String COMMA = ",";
    private static final String[] EMPTY_ARRAY = new String[0];

    public String[] split(final String value) {
        if (value.isEmpty()) {
            return EMPTY_ARRAY;
        }
        return value.split(COMMA);
    }
}
