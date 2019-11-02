package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoMachine {

    private NumberGenerator numberGenerator;

    LottoMachine() {
        final int lottoNumberCount = 6;
        final int lottoNumberLimit = 45;
        numberGenerator = new NumberGenerator(lottoNumberCount, lottoNumberLimit);
    }

    Lotto issue() {
        List<Integer> numbers = numberGenerator.generate();
        return new Lotto(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMachine that = (LottoMachine) o;
        return Objects.equals(numberGenerator, that.numberGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberGenerator);
    }
}
