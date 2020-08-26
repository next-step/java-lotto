package lotto.domain;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class ManualLottoGenerator implements LottoGenerator {
    private final List<List<Integer>> manuals;

    public ManualLottoGenerator(List<List<Integer>> manuals) {
        this.manuals = manuals;
    }

    public static ManualLottoGenerator of(List<List<Integer>> manuals) {
        return new ManualLottoGenerator(manuals);
    }

    @Override
    public Lottos generate() {
        return manuals.stream()
                .map(Lotto::of)
                .collect(collectingAndThen(toList(), Lottos::of));
    }
}
