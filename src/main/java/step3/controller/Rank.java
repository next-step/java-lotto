package step3.controller;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    MISS(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private static final int LOTTO_PRICE = 1000;
    private final boolean matchBonus;
    public int countOfMatch;
    public int winningMoney;

    Rank(int countOfMatch, int winningMoney, boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.matchBonus = matchBonus;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank[] ranks = values();
        Rank rank = Arrays.stream(ranks)
                .filter(r -> r.countOfMatch == countOfMatch).findFirst().get();
        if(rank.matchBonus == true) {
            rank = SECOND;
        }
        if(countOfMatch < 3) {
            rank = MISS;
        }
        return rank;
    }

//    public static int sum(int[] result) {
//        Rank[] rank = values();
//        int sum = 0;
//        for(int i = 0 ; i < result.length ; i++) {
//            int finalI = i;
//            int money = Arrays.stream(rank).filter(r -> r.countOfMatch == result[finalI])
//                    .findFirst().get().winningMoney;
//            sum += money * result[i];
//        }
//        return sum;
//    }

    public static float revenue(List<Rank> ranks) {
        Rank[] rank = values();
        int sum = 0;
        for(Rank r : rank) {
            sum += ranks.parallelStream().filter(data
                    -> data == r).mapToInt(matchData -> matchData.winningMoney).sum();
        }
        return (float)sum / (ranks.size() * LOTTO_PRICE);
    }

    public static int[] result(List<Rank> ranks) {
        Rank[] rank = values();
        int[] result = new int[rank.length];
        for(int i = 0 ; i < rank.length; i++) {
            result[i] = 0;
        }

        for(int i = 0; i < rank.length; i++) {
            Rank r = rank[i];
            result[i] += ranks.parallelStream()
                    .filter(data -> data == r).mapToInt(matchData -> 1).sum();
//            System.out.println(result[i]);
        }
//        System.out.println("---");
//        System.out.println(result.toString());

        return result;
    }

}
