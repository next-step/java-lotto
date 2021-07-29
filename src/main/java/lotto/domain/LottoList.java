package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class LottoList {
    private final List<Lotto> values;

    private LottoList(List<Lotto> values) {
        this.values = values;
    }

    public static LottoList newAuto(Number size) {
        return newAuto(size.intValue());
    }

    public static LottoList newAuto(int size) {
        List<Lotto> newValues = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            newValues.add(Lotto.newAuto());
        }
        return new LottoList(newValues);
    }

    public LottoStatistics statistics() {
        Map<LottoRank, Long> data = this.values.stream().collect(
                Collectors.groupingBy(Lotto::rank, Collectors.counting())
        );
        return new LottoStatistics(data);
    }

    public int size() {
        return values.size();
    }
}
