package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ManualLottos {
    private final List<Lotto> manualLottos;

    public ManualLottos(List<Lotto> manualLottos) {
        this.manualLottos = Optional.ofNullable(manualLottos)
                .orElse(Collections.emptyList());
    }

    public int getCount() {
        return manualLottos.size();
    }

    public List<Lotto> getManualLottos() {
        return List.copyOf(manualLottos);
    }
}
