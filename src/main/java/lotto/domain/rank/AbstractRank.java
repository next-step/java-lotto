package lotto.domain.rank;

public abstract class AbstractRank implements Rank {

    protected int score = 0;

    @Override
    public int score() {
        return score;
    }

}
