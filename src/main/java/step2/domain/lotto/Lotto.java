package step2.domain.lotto;

public class Lotto {

    private final LottoNumber numbers;

    private Lotto(LottoNumber numbers) {
        this.numbers = numbers;
    }

    public static Lotto create(LottoNumber lottoNumber) {
        return new Lotto(lottoNumber);
    }

    public LottoNumber numbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
