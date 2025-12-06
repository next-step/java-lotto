package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottosGenerator implements LottoGenerator {
    private final List<String> manualLottos;

    public ManualLottosGenerator(List<String> manualLottos) {
        this.manualLottos = manualLottos;
    }

    @Override
    public List<Lotto> generate() {
        return manualLottos.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }
}
