package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<NumberGroup> numberGroups;

    public Lotto(List<NumberGroup> numberGroups) {
        this.numberGroups = numberGroups;
    }

    public boolean appropriate(int count) {
        return numberGroups.size() == count;
    }

    public void match(NumberGroup winningNumbers) {
        for (NumberGroup numberGroup :
                numberGroups) {
            numberGroup.match(winningNumbers);
        }
    }

    public List<NumberGroup> getNumberGroups() {
        return numberGroups;
    }
}
