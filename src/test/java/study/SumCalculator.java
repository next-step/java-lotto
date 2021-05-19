package study;

public class SumCalculator {
    private final String input;
    public SumCalculator(String input) {
        this.input = input;
    }

    public boolean isUnUsable() {
        return isNull() || isEmpty();
    }

    private boolean isEmpty() {
        return input.isEmpty();
    }

    private boolean isNull() {
        return input == null;
    }

    public int sum() {
        return 0; // TODO: 로직 추가
    }
}
