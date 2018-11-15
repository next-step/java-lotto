package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.toIntExact;
import static lotto.utils.LottoCollectionUtils.merge;

public class LottoSet {

    private List<Lotto> lottos;

    private LottoSet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoSet create(List<Lotto> lottos) {
        return new LottoSet(lottos);
    }

    public static LottoSet create(int count) {
        return new LottoSet(createByAutomatic(count));
    }

    public static LottoSet create(int count, List<Lotto> lottos) {
        return new LottoSet(merge(createByAutomatic(count), lottos));
    }

    private static List<Lotto> createByAutomatic(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.create());
        }
        return lottos;
    }

    public int sizeOfAutomatic() {
        return toIntExact(this.lottos.stream()
                .filter(Lotto::isAutomatic)
                .count());
    }

    public int sizeOfManual() {
        return toIntExact(this.lottos.stream()
                .filter(Lotto::isManual)
                .count());
    }

    public int numberOfMatches(List<LottoNo> winningNumbers, int count) {
        return toIntExact(this.lottos.stream()
                .filter(lotto -> lotto.hasMatches(winningNumbers, count))
                .count());
    }

    @Override
    public String toString() {
        return this.lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
