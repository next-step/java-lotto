package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {
    private final List<Lotto> manualLottos;
    public ManualLottoGenerator(List<Set<Integer>> manualLottos) {
        this.manualLottos = manualLottos.stream()
                .map(lotto -> new Lotto(lotto.stream().mapToInt(i -> i).toArray()))
                .collect(Collectors.toList());
    }

    public ManualLottoGenerator(Lotto... lottos) {
        this.manualLottos = Arrays.stream(lottos).collect(Collectors.toList());
    }

    @Override
    public List<Lotto> generate() {
        return manualLottos;
    }
}
