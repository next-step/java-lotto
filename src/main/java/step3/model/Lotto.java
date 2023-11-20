package step3.model;

import java.util.Arrays;

public class Lotto {

    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public LottoNumbers getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.numbers.getNumbers().toArray());
    }
}
