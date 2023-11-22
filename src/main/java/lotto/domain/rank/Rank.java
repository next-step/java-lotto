package lotto.domain.rank;

public interface Rank {

    int score = 0;

    boolean integerEqualToRank(int integer);

    void addScore(int score);

    int getScore();

    int getRank();

}
