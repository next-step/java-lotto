package step1;

public class Element {
    static final String ALERT_FOR_NEGATIVE_NUMBER = "음수는 아니되옵니다.";
    static final String ALERT_FOR_INVALID_INPUT_VALUE = "0 이상의 자연수만 가능합니다.";
    static final String REGEX_ALLOWS_NUMBERS_ONLY = "[0-9]\\d*";
    static final int MINIMUM_ALLOWED_VALUE = 0;

    private int value;

    public Element(int value) {
        this.value = value;
    }

    public static Element from(int value) {
        if (value < MINIMUM_ALLOWED_VALUE) {
            throw new RuntimeException(ALERT_FOR_NEGATIVE_NUMBER);
        }
        return new Element(value);
    }

    public static Element from(String inputString) {
        if (!inputString.matches(REGEX_ALLOWS_NUMBERS_ONLY)) {
            throw new RuntimeException(ALERT_FOR_INVALID_INPUT_VALUE);
        }
        return Element.from(Integer.parseInt(inputString));
    }

    public int getValue() {
        return value;
    }
}
