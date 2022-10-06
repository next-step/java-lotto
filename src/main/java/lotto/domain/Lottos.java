package lotto.domain;

import lotto.domain.type.Rank;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private static final String ZERO_QUANTITY_EXCEPTION_MESSAGE = "0이하 생성은 불가능합니다.";
    private final List<Lotto> values;

    public static Lottos create(List<Lotto> values) {
        return new Lottos(values);
    }

    public Lottos(List<Lotto> values) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException(ZERO_QUANTITY_EXCEPTION_MESSAGE);
        }

        this.values = values;
    }

    public List<Lotto> values() {
        return Collections.unmodifiableList(values);
    }

    public int quantity() {
        return values.size();
    }

    public List<Rank> match(Lotto winLotto, LottoNumber bonusNumber) {
        return values.stream()
                .map(l -> l.rank(winLotto, bonusNumber))
                .collect(Collectors.toUnmodifiableList());
    }

    public Lottos add(Lottos other) {
        this.values.addAll(other.values);

        return new Lottos(values);
    }
}
