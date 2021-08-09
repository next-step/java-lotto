package step2.lotto;

public class Lotto {

    public static final int PRICE = 1_000;
    public static final long COUNT_OF_MATCHES_FIRST = 6;
    public static final long COUNT_OF_MATCHES_SECOND = 5;
    public static final long COUNT_OF_MATCHES_THIRD = 4;
    public static final long COUNT_OF_MATCHES_FOURTH = 3;

    private final LottoNumber number;

    public Lotto(LottoNumber number) {
        this.number = number;
    }

    public LottoNumber getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
