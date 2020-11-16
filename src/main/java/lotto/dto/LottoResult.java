package lotto.dto;

import lotto.domain.Lotto;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoResult {
    private final Set<Integer> lotto;

    private LottoResult(Set<Integer> lotto) {
        this.lotto = lotto;
    }

    public static LottoResult of(Lotto lotto) {
        return new LottoResult(lotto.getLotto());
    }

    @Override
    public String toString() {
        return this.lotto.stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
