package splitter;

public class CommaAndColonSplitter implements Splitter {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    @Override
    public boolean support(final String value) {
        return true;
    }

    @Override
    public String[] split(final String value) {
        if (value.isEmpty()) {
            return EMPTY_ARRAY;
        }
        return value.split(DEFAULT_DELIMITER_REGEX);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
