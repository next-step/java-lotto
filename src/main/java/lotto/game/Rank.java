package lotto.game;

import java.util.Arrays;

public enum Rank {
    FIRST_WIN(6, 2000000000),
    SECOND_WIN(5, 1500000),
    THIRD_WIN(4, 50000),
    FORTH_WIN(3, 5000),
    LOSE(2, 0),
    ;

    public int count;
    public int award;

    Rank(int count, int award) {
        this.count = count;
        this.award = award;
    }

    public static Rank of(int count) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.count == count)
                .findFirst()
                .orElse(Rank.LOSE);
    }
}
