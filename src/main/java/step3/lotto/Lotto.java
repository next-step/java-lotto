package step3.lotto;

public class Lotto {

    public static final int PRICE = 1_000;

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
