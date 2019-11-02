package lotto.domain;

import java.util.List;
import java.util.Objects;

public class BasicLottoMachine implements LottoMachine {

    private NumberGenerator numberGenerator;

    public BasicLottoMachine(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public Lotto issue() {
        List<Integer> numbers = numberGenerator.generate();
        return new Lotto(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicLottoMachine that = (BasicLottoMachine) o;
        return Objects.equals(numberGenerator, that.numberGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberGenerator);
    }
}
