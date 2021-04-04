package lotto.domain;

import lotto.constants.Constants;
import lotto.generator.NumberGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<Number> lotto;

    private Lotto(final Set<Number> lotto) {
        this.lotto = lotto;
    }

    public static Lotto from(final NumberGenerator numberGenerator) {
        Set<Number> lotto = new HashSet<>();
        for (Integer number : numberGenerator.generator()) {
            lotto.add(Number.from(number));
        }
        return new Lotto(lotto);
    }

    public static Lotto from(final Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != Constants.LOTTO_SIZE) {
            throw new RuntimeException("로또 숫자는 6개이여야 합니다.");
        }
        return new Lotto(lottoNumbers.stream()
                .map(number -> Number.from(number))
                .collect(Collectors.toSet()));
    }

    public void checkValidBonusNumber(final Number bonusNumber) {
        if (this.lotto.contains(bonusNumber)) {
            throw new RuntimeException("보너스번호는 1등 당첨번호와 중복될 수 없습니다.");
        }
    }

    public Rank getRank(final Lotto prizeLotto, final Number bonusNumber) {
        int matchCount = matchCount(prizeLotto);
        boolean matchBonus = matchBonus(bonusNumber);
        return Rank.valueOf(matchCount, matchBonus);
    }

    private int matchCount(final Lotto prizeLotto) {
        return (int) prizeLotto.getNumbers()
                .stream()
                .filter(number -> this.lotto.contains(number))
                .count();
    }

    private boolean matchBonus(final Number bonusNumber) {
        return lotto.stream()
                .anyMatch(number -> number.equals(bonusNumber));
    }

    public Set<Number> getNumbers() {
        return Collections.unmodifiableSet(lotto);
    }
}
