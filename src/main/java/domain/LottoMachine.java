package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private List<Integer> machine;

    private void basicNumber() {
        machine = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            machine.add(i);
        }
    }

    public LottoMachine() {
        basicNumber();
    }

    public List<Integer> pull() {
        Collections.shuffle(machine);
        List<Integer> newLotto = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            newLotto.add(machine.get(i));
        }
        Collections.sort(newLotto);
        return newLotto;
    }
}
