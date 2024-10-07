package calculator;

public class StringCalculator {
    private static StringCalculator INSTANCE = null;

    private StringCalculator() {
    }

    public static StringCalculator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StringCalculator();
        }
        return INSTANCE;
    }

    public String[] split(String text) {
        if(text == null || text.isBlank()){
            throw new IllegalStateException("문자열이 비어있습니다.");
        }
        return text.split(" ");
    }
}
