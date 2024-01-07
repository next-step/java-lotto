package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public static LottoNumber of(int number) {
        validate(number);
        return AllLottoNumber.getLottoNumber(number);
    }

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private static void validate(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("0보다 크고, 46보다 작은 수를 입력해주세요");
        }
    }

    public static LottoNumber lottoNumberFactory(int number) {
        validate(number);
        return new LottoNumber(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }
}
