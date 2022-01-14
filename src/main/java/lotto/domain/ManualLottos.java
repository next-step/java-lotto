package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import lotto.utils.FixNumberStrategy;
import lotto.utils.NumberStrategy;

public class ManualLottos {

    List<Lotto> manualLottos;

    public ManualLottos() {
        this.manualLottos = new ArrayList<>();
    }

    public void addManualLotto(Set<Integer> manualNumber) {
        NumberStrategy numberStrategy = new FixNumberStrategy(new ArrayList<>(manualNumber));
        manualLottos.add(new Lotto(numberStrategy));
    }

    public List<Lotto> getManualLottos() {
        return Collections.unmodifiableList(manualLottos);
    }
}
