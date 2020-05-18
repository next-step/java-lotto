package splitter;

public class CommaAndColonSplitter implements Splitter{

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    @Override
    public String[] split(final String value) {
        if (value.isEmpty()) {
            return EMPTY_ARRAY;
        }
        return value.split(DEFAULT_DELIMITER_REGEX);
    }
}
