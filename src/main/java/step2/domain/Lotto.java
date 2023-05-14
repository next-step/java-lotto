package step2.domain;

import java.util.ArrayList;

public class Lotto implements Comparable<Lotto>{

    private int value;

    public Lotto (int number) {
        this.value = number;
    }

    public int getNumber() {
        return this.value;
    }

    @Override
    public int compareTo(Lotto lotto) {
        if (lotto.value < value) {
            return 1;
        } else if (lotto.value > value) {
            return -1;
        }
        return 0;
    }

    public boolean isEqual(Lotto lotto) {
        if (this.value == lotto.getNumber()) return true;
        return false;
    }
}
