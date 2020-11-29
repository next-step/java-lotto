package my.project.lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final String LOTTO_NUMBER_IS_BETWEEN = "로또 번호는 1과 45 사이입니다.";

    private final int number;

    public LottoNumber(int number) {
        if (number < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_BETWEEN);
        }
        if (number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_BETWEEN);
        }
        this.number = number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
