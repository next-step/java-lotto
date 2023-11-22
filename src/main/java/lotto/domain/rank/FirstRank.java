package lotto.domain.rank;

public class FirstRank extends AbstractRank {

    private static final int RANK = 6;

    public static FirstRank of() {
        return new FirstRank();
    }

    @Override
    public boolean integerEqualToRank(int integer) {
        return integer == RANK;
    }

    @Override
    public int getRank() {
        return RANK;
    }

    @Override
    public String toString() {
        return String.valueOf(RANK);
    }
}
