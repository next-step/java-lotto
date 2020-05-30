package lotto.domain;

import java.util.List;

public class Lotto {

    List<Integer> numberList;

    public Lotto() {
    }

    public Lotto(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public boolean isContainsNumber(int number) {
        return numberList.stream()
                .anyMatch(integer -> integer == number);
    }
}
