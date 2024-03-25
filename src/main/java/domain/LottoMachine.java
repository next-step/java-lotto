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

    public Lotto pull() {
        Collections.shuffle(machine);
        Lotto nowLotto = new Lotto(machine.subList(0, 6));
        return nowLotto;
    }
}
