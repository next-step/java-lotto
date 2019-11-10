package step2.domain;

import java.util.List;

public class SameLottoNumberGenerator implements LottoNumberGenerator {
    private final List<Integer> numbers;

    public SameLottoNumberGenerator(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public LottoNumbers generate() {
        return new LottoNumbers(numbers);
    }
}
