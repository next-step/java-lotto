package AutoLotto.domain.play;

import java.util.Arrays;

public enum Rank {
    FIRST(6,  2000000000),
    SECOND(5,1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    public final int matchCount;
    public final int rankMoney;

    Rank(int matchCount, int rankMoney){
        this.matchCount = matchCount;
        this.rankMoney = rankMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getRankMoney() {
        return rankMoney;
    }

    public static Rank matchOf(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchCount(matchCount))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }



//    int createBuzzMoney(PlayLotto playLotto) {
//        int sum = 0;
//        int hits1 = playLotto.countHits()
//                .stream()
//                .filter(o -> o.equals(Rank.FIRST.hits))
//                .mapToInt(o -> 1)
//                .sum();
//        sum += hits1 * Rank.FIRST.rankMoney;
//        int hits2 = playLotto.countHits()
//                .stream()
//                .filter(o -> o.equals(Rank.SECOND.hits))
//                .mapToInt(o -> 1)
//                .sum();
//        sum +=  hits2 * Rank.SECOND.rankMoney;
//        int hits3 = playLotto.countHits()
//                .stream()
//                .filter(o -> o.equals(Rank.THIRD.hits))
//                .mapToInt(o -> 1)
//                .sum();
//        sum += hits3 * Rank.THIRD.rankMoney;
//        int hits4 = playLotto.countHits()
//                .stream()
//                .filter(o -> o.equals(Rank.FOURTH.hits))
//                .mapToInt(o -> 1)
//                .sum();
//        sum += hits4 * Rank.FOURTH.rankMoney;
//        return sum;
//    }
}
