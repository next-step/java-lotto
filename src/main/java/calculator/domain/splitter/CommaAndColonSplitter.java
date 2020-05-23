package calculator.domain.splitter;

public class CommaAndColonSplitter implements Splitter {
    private static final String COMMA_COLON_DELIMITER_REGEX = "[,:]";

    @Override
    public String[] split(String input) {
        return input.split(COMMA_COLON_DELIMITER_REGEX);
    }

    @Override
    public boolean isSupport(String input) {
        return true;
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
