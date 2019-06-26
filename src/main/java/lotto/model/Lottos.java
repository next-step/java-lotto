package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final static String STRING_ENTER = "\n";
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

    int size() {
        return pickNumbers.size();
    }

    public void merge(Lottos handPickLottos) {
        this.pickNumbers.addAll(handPickLottos.getPickNumbers());
    }

    @Override
    public String toString() {
        List<String> lottos = this.pickNumbers.stream()
                .map(PickNumbers::toString)
                .collect(Collectors.toList());
        return String.join(STRING_ENTER, lottos);
    }
}
