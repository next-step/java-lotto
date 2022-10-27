package lotto.domain;

public class LottoCount {
    private static final String LOTTO_COUNT_MESSAGE = "로또의 장수는 0또는 자연수만 가능합니다.";

    private final int count;

    public LottoCount(String count) {
        this(validate(toInt(count)));
    }

    public LottoCount(int count) {
        this.count = count;
    }

    public int minus(LottoCount count) {
        if (this.count >= count.count) {
            return this.count - count.count;
        }
        return count.count - this.count;
    }

    private static int validate(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(LOTTO_COUNT_MESSAGE);
        }
        return count;
    }

    private static int toInt(String count) {
        try {
            return Integer.parseInt(count);
        } catch (Exception e) {
            throw new IllegalArgumentException(LOTTO_COUNT_MESSAGE);
        }
    }

    public int number() {
        return count;
    }
}
