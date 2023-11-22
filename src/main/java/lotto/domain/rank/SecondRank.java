package lotto.domain.rank;

public class SecondRank extends AbstractRank{

    private static final int RANK = 5;

    public static SecondRank of() {
        return new SecondRank();
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
