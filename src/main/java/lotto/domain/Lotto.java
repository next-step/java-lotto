package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private List<Integer> numberList;
    private Rank rank;

    public Lotto(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public Rank getRank() {
        return rank;
    }

    public Lotto matchRank(List<Integer> winnerNumberList) {
        this.rank = Rank.getRank(
                (int) numberList
                        .stream()
                        .filter(winnerNumberList::contains)
                        .count());
        return this;
    }

    public int match() {
        return rank.getCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numberList, lotto.numberList) && rank == lotto.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberList, rank);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numberList=" + numberList +
                ", rank=" + rank +
                '}';
    }
}
