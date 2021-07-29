package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public final class LottoList implements Iterable<Lotto> {
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

    public LottoStatistics statistics(Lotto prizeLotto) {
        Map<LottoRank, Long> data = this.values.stream().collect(
                Collectors.groupingBy(iLotto -> iLotto.rank(prizeLotto), Collectors.counting())
        );
        return new LottoStatistics(data);
    }

    public int size() {
        return values.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return values.iterator();
    }
}
