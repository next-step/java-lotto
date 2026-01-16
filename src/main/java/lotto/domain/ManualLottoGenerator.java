package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {

    private final List<Lotto> manualList;

    public ManualLottoGenerator(List<Lotto> manualList) {
        this.manualList = manualList;
    }

    public static ManualLottoGenerator from(List<String> manualList) {
        return new ManualLottoGenerator(manualList.stream()
                .map(Lotto::new)
                .collect(Collectors.toList()));
    }

    @Override
    public Lottos generate() {
        return new Lottos(manualList);
    }
}
