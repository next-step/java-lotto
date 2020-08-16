import java.util.Objects;

public class Delimiter {
    private static final String DEFAULT_DELIMITER_PATTERN = "[,:]";
    private String delimiter;

    private Delimiter(String expression) {
        if (ExpressionValidator.isCustomDelimiterExist(expression)) {
            this.delimiter = extractCustomDelimiter(expression);
            return;
        }

        this.delimiter = DEFAULT_DELIMITER_PATTERN;
    }

    private String extractCustomDelimiter(String expression) {
        return expression.replaceAll("([0-9])(.[0-9])*", "")
                .replaceAll("//", "")
                .replaceAll("\n", "");
    }

    public static Delimiter newInstance(String expression) {
        return new Delimiter(expression);
    }

    public String pattern() {
        return this.delimiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delimiter delimiter1 = (Delimiter) o;
        return Objects.equals(delimiter, delimiter1.delimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiter);
    }
}
