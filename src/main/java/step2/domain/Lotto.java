package step2.domain;

import step2.constants.Constants;
import step2.generator.NumberGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private final Set<Number> lotto;

    private Lotto(final Set<Number> lotto) {
        this.lotto = lotto;
    }

    public static Lotto from(NumberGenerator numberGenerator) {
        Set<Number> lotto = new HashSet<>();
        for (Integer number : numberGenerator.generator()) {
            lotto.add(Number.from(number));
        }
        return new Lotto(lotto);
    }

    public static Lotto from(Set<Number> lotto) {
        if (lotto.size() != Constants.LOTTO_SIZE) {
            throw new RuntimeException("로또 숫자는 6개이여야 합니다.");
        }
        return new Lotto(lotto);
    }

    public int getMatchCount(Lotto prizeLotto) {
        return (int) prizeLotto.getNumbers()
                .stream()
                .filter(number -> this.lotto.contains(number))
                .count();
    }

    public Set<Number> getNumbers() {
        return Collections.unmodifiableSet(lotto);
    }
}
