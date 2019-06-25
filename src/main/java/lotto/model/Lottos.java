package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<PickNumbers> pickNumbers;

    public Lottos() {
        this.pickNumbers = new ArrayList<>();
    }

    public Lottos add(PickNumbers newPick) {
        this.pickNumbers.add(newPick);
        return this;
    }

    public List<PickNumbers> getPickNumbers() {
        return pickNumbers;
    }

    public void merge(Lottos handPickLottos) {
        this.pickNumbers.addAll(handPickLottos.getPickNumbers());
    }
}
