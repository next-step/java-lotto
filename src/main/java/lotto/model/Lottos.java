package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class Lottos {
    private static final int DEFAULT_VALUE = 0;
    private static final int ADD_COUNT = 1;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = new ArrayList<>(lottos);
    }

    private void validate(List<Lotto> lottos) {
        Objects.requireNonNull(lottos, "lottos 생성을 위한 입력이 올바르지 않습니다. lottos is null");

        if (lottos.isEmpty()) {
            throw new IllegalArgumentException("lottos 생성을 위한 입력이 올바르지 않습니다. lottos is empty");
        }
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> get() {
        return Collections.unmodifiableList(lottos);
    }

    public Map<Rank, Integer> getLottoStatistics(Lotto winnerLotto) {
        validate(winnerLotto);
        Map<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank key = Rank.of(lotto.getMatchCount(winnerLotto));
            result.put(key, result.getOrDefault(key, DEFAULT_VALUE) + ADD_COUNT);
        }
        return result;
    }

    private static void validate(Lotto winnerLotto) {
        Objects.requireNonNull(winnerLotto, "당첨 로또를 올바르게 입력해주세요. input is null");
    }
}
