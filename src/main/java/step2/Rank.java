package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

    FIRST(1, 6, 2000000000),
    SECOND(2, 5, 1500000),
    THIRD(3, 4, 50000),
    FORTH(4, 3, 5000),
    EMPTY(0, 0, 0);


    private int rank;
    private int match;
    private int reward;
    private int count = 0;


    Rank(int rank, int match, int reward) {
        this.rank = rank;
        this.match = match;
        this.reward = reward;
    }

    public static Rank matches(int match) {
        return Arrays.stream(values())
                .filter(rank -> rank.match == match)
                .findFirst()
                .orElse(EMPTY);
    };

    public static List<Rank> getCounted() {
        return Arrays.stream(values())
                .filter(Rank::isNotEmpty)
                .collect(Collectors.toList());
    }

    public static int getTotal() {
        return Arrays.stream(values())
                .mapToInt(Rank::getProfit)
                .sum();
    }

    public boolean isEmpty() {
        return this.equals(Rank.EMPTY);
    }

    public boolean isNotEmpty() {

        return !this.equals(Rank.EMPTY);
    }

    public void count() {
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public int getProfit() {
        return reward * count;
    }

    public int getMatch() {
        return match;
    }

    public int getReward() {
        return reward;
    }


}
