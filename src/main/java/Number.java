public class Number {
    private final long number;

    private static final String INTEGER_REGEX = "-?\\d+";

    public Number(String number) {
        if (!isNumber(number)) {
            throw new IllegalArgumentException("유효하지 않은 문자열입니다.");
        }
        this.number = Long.parseLong(number);
    }

    private boolean isNumber(String numberAndOperation) {
        return numberAndOperation.matches(INTEGER_REGEX);
    }

    public long getNumber() {
        return number;
    }
}
