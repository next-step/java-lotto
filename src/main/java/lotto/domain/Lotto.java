package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numberList;
    private Rank rank;

    public Lotto(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public Lotto rank(List<Integer> matchNumberList) {
        this.rank = Rank.valueOf((int) numberList
                .stream()
                .filter(matchNumberList::contains)
                .count());
        return this;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public Rank getRank() {
        return rank;
    }
}
