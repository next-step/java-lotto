package step1;

public class NumericalExpression {

    public static final String SEPARATOR = ",";

    private final String text;

    public NumericalExpression(String text) {
        this.text = text;
    }

    public String[] split() {
        return text.split(SEPARATOR);
    }

}
