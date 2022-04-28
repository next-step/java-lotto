package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Lottos {
    private static final int LOTTO_COUNT = 6;

    private final List<Integer> lottos;

    Lottos(List<Integer> lottos) {
        validate(lottos);
        this.lottos = new ArrayList<>(lottos);
    }

    private void validate(List<Integer> lottos) {
        Objects.requireNonNull(lottos, "lottos는 null일 수 없습니다.");
        if (lottos.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("lottos 의 사이즈는 6이어야 합니다.");
        }
    }

    public List<Integer> get() {
        return Collections.unmodifiableList(lottos);
    }
}
