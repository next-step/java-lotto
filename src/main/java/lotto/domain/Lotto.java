package lotto.domain;

import java.util.List;

public class Lotto {

    private List<Integer> numberList;
    private Rank rank;

    public List<Integer> getNumberList() {
        return numberList;
    }

    public Rank getRank() {
        return rank;
    }

    public Lotto makeNumbers(List<Integer> numberList) {
        this.numberList = numberList;
        return this;
    }

    public Lotto matchRank(List<Integer> winnerNumberList) {
        this.rank = Rank.getRank(
                (int) numberList
                        .stream()
                        .filter(winnerNumberList::contains)
                        .count());
        return this;
    }
}
