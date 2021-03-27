package step2.domain;

import step2.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Number> lotto;

    private Lotto(final List<Number> lotto) {
        this.lotto = lotto;
    }

    public static Lotto from(NumberGenerator numberGenerator) {
        List<Number> lotto = new ArrayList<>();
        for (Integer number : numberGenerator.generator()) {
            lotto.add(Number.from(number));
        }
        return new Lotto(lotto);
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(lotto);
    }
}
