package lotto.domain.rank;

public class ThirdRank extends AbstractRank{

    private static final int RANK = 4;

    public static ThirdRank of() {
        return new ThirdRank();
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
