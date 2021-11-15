package lotto;

public class Dollars {

    public static final String ILLEGAL_RANGE_ERROR_MESSAGE = "1000이상의 값이 필요합니다.";
    private static final int DOLLAR_UNIT = 1000;
    private static final int MIN_COUNT = 1;

    private final int count;

    public Dollars(int won) {
        count = toCount(won);
    }

    private int toCount(int won) {
        int count = won / DOLLAR_UNIT;
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException(ILLEGAL_RANGE_ERROR_MESSAGE);
        }
        return count;
    }

    public int getCount() {
        return count;
    }
}
