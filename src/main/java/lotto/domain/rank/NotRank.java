package lotto.domain.rank;

public class NotRank extends AbstractRank{

    private static final int MIN_RANK = 2;

    public static NotRank of() {
        return new NotRank();
    }

    @Override
    public boolean integerEqualToRank(int integer) {
        return integer <= MIN_RANK;
    }

    @Override
    public int getRank() {
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(MIN_RANK);
    }
}
