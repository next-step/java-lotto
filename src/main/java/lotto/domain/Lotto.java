package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numberList;

    public Lotto(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

}
