package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final List<Integer> machine = new ArrayList<>();

    private void basicNumber() {
        for (int i = 1; i <= 45; i++) {
            machine.add(i);
        }
    }

    public LottoMachine() {
        basicNumber();
    }

    public List<Integer> pull() {
        Collections.shuffle(machine);
        return machine.subList(0, 6);
    }
}
