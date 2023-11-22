package lotto.domain.rank;

public class BonusRank extends AbstractRank{

    public static BonusRank of() {
        return new BonusRank();
    }

    @Override
    public boolean integerEqualToRank(int integer) {
        return false;
    }

    @Override
    public int getRank() {
        return 0;
    }

}
