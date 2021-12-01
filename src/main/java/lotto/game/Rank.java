package lotto.game;

import java.util.Arrays;

public enum Rank {
    FIRST_WIN(6),
    SECOND_WIN(5),
    THIRD_WIN(4),
    FORTH_WIN(3),
    LOSE(2),
    ;

    public int count;

    Rank(int count) {
        this.count = count;
    }

    public static Rank of(int count) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.count == count)
                .findFirst()
                .orElse(Rank.LOSE);
    }
}
