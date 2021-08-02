package step2.domain;

import java.util.List;

public class Lotto {

    private final LottoNumber numbers;

    private Lotto(LottoNumber numbers) {
        this.numbers = numbers;
    }

    public static Lotto create(LottoNumber lottoNumber) {
        return new Lotto(lottoNumber);
    }

    public List<Integer> numbers() {
        return numbers.getNumbers();
    }

    @Override
    public String toString() {
        return "Lotto{" +
            "numbers=" + numbers +
            '}';
    }
}
