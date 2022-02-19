package lotto.domain.lotto.count;

public class Count {

    private final Integer value;

    public Count(String value) {
        this(parseToInteger(value));
    }

    private static Integer parseToInteger(String value) {
        if (!value.matches("[-]?[0-9]*")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 들어올 수 있습니다.");
        }
        return Integer.parseInt(value);
    }

    public Count(Integer value) {
        validCount(value);
        this.value = value;
    }

    private void validCount(Integer value) {
        validRange(value);
    }

    private void validRange(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException("[ERROR] 구매 개수가 0보다 작을 수는 없습니다.");
        }
    }

    public Integer getValue() {
        return value;
    }
}
