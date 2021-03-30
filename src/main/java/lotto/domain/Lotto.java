package lotto.domain;

import lotto.constants.Constants;
import lotto.generator.NumberGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<Number> lotto;
    private final Number bonusNumber;

    private Lotto(final Set<Number> lotto) {
        this(lotto, Number.from(0));
    }

    private Lotto(final Set<Number> lotto, Number bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static Lotto from(final NumberGenerator numberGenerator) {
        Set<Number> lotto = new HashSet<>();
        for (Integer number : numberGenerator.generator()) {
            lotto.add(Number.from(number));
        }
        return new Lotto(lotto);
    }

    public static Lotto from(final Set<Integer> lottoNumbers, final int bonusNumber) {
        if (lottoNumbers.size() != Constants.LOTTO_SIZE) {
            throw new RuntimeException("로또 숫자는 6개이여야 합니다.");
        }
        return new Lotto(lottoNumbers.stream()
                .map(number -> Number.from(number))
                .collect(Collectors.toSet()), Number.from(bonusNumber));
    }

    public int getMatchCount(final Lotto prizeLotto) {
        return (int) prizeLotto.getNumbers()
                .stream()
                .filter(number -> this.lotto.contains(number))
                .count();
    }

    public Set<Number> getNumbers() {
        return Collections.unmodifiableSet(lotto);
    }
}
