package step2;

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
}
