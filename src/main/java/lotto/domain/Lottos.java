package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> manualLottos;
    private final List<Lotto> autoLottos;

    public Lottos(final List<Lotto> manualLottos, final List<Lotto> autoLottos) {
        this.manualLottos = manualLottos;
        this.autoLottos = autoLottos;
    }

    public int countManualLottos() {
        return this.manualLottos.size();
    }

    public int countAutoLottos() {
        return this.autoLottos.size();
    }

    public List<Lotto> allLottos() {
        return Stream.concat(this.manualLottos.stream(), this.autoLottos.stream())
                .collect(Collectors.toUnmodifiableList());
    }
}
