package lotto.domain.number;

public class LottoNumber {

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }
}
