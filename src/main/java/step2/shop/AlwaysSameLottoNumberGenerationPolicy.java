package step2.shop;

import java.util.Collections;
import java.util.List;

class AlwaysSameLottoNumberGenerationPolicy implements LottoNumberGenerationPolicy {
    private final List<Integer> numbers;

    AlwaysSameLottoNumberGenerationPolicy(final List<Integer> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    @Override
    public List<Integer> nextSix() {
        return numbers;
    }
}
