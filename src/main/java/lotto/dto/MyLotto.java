package lotto.dto;

import lotto.domain.Lotto;

import java.util.Set;
import java.util.stream.Collectors;

public class MyLotto {
    private final Set<Integer> lotto;

    private MyLotto(Set<Integer> lotto) {
        this.lotto = lotto;
    }

    public static MyLotto of(Lotto lotto) {
        return new MyLotto(lotto.getLotto());
    }

    @Override
    public String toString() {
        return this.lotto.stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
