package calculator;

public class StringAddCalculator {

    public static final int ZREO = 0;

    public static int splitAndSum(final String text) {
        if (text == null || text.isEmpty()) {
            return ZREO;
        }

        StringDelimiter stringDelimiter = new StringDelimiter();
        String[] texts = stringDelimiter.parse(text);
        Numbers numbers = Numbers.from(texts);
        return numbers.sum();
    }
}
