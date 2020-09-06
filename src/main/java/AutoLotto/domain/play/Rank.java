package AutoLotto.domain.play;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Rank {
    FIRST(6,  2000000000),
    SECOND(5,1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    public final int hits;
    public final int rankMoney;

    Rank(int hits, int rankMoney){
        this.hits = hits;
        this.rankMoney = rankMoney;
    }

    public int getHits() {
        return hits;
    }

    public int getRankMoney() {
        return rankMoney;
    }

//    public static Rank of(String value) {
//        Optional<Rank> maybeRank = Arrays.stream(values( )).
//                filter(o -> o.hits == Integer.parseInt(value)).findFirst();
//        return maybeRank.orElseThrow(IllegalArgumentException::new);
//    }

    int createBuzzMoney(PlayLotto playLotto) {
        int sum = 0;
        int hits1 = playLotto.countHits()
                .stream()
                .filter(o -> o.equals(Rank.FIRST.hits))
                .mapToInt(o -> 1)
                .sum();
        sum += hits1 * Rank.FIRST.rankMoney;
        int hits2 = playLotto.countHits()
                .stream()
                .filter(o -> o.equals(Rank.SECOND.hits))
                .mapToInt(o -> 1)
                .sum();
        sum +=  hits2 * Rank.SECOND.rankMoney;
        int hits3 = playLotto.countHits()
                .stream()
                .filter(o -> o.equals(Rank.THIRD.hits))
                .mapToInt(o -> 1)
                .sum();
        sum += hits3 * Rank.THIRD.rankMoney;
        int hits4 = playLotto.countHits()
                .stream()
                .filter(o -> o.equals(Rank.FOURTH.hits))
                .mapToInt(o -> 1)
                .sum();
        sum += hits4 * Rank.FOURTH.rankMoney;
        return sum;
    }
}
