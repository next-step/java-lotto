package lotto.domain.rank;

public class FourthRank extends AbstractRank{

    private static final int RANK = 3;

    public static FourthRank of() {
        return new FourthRank();
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
