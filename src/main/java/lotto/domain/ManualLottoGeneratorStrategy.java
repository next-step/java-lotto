package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGeneratorStrategy implements LottoGeneratorStrategy {

    private final List<String> lottos;

    public ManualLottoGeneratorStrategy(List<String> lottos) {
        this.lottos = lottos;
    }

    @Override
    public List<Lotto> generateLottos() {
        return lottos.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }
}
