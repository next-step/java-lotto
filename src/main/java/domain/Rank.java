package domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    RANK_ONE(2_000_000_000, 6),
    RANK_TWO(30_000_000, 5),
    RANK_THREE(1_500_000, 5),
    RANK_FOUR(50_000, 4),
    RANK_FIVE(5_000, 3),
    MISS(0, 0);

    private int winnerPrice;
    private int count;

    Rank(int winnerPrice, int count) {
        this.winnerPrice = winnerPrice;
        this.count = count;
    }

    public int getWinnerPrice() {
        return winnerPrice;
    }

    public int getCount() {
        return count;
    }

    public static Rank valueOf(int count, boolean matchBonus) {
        // TODO 일치하는 수를 로또 등수로 변경한다.
        //  enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
        Rank[] ranks = values();

        if (matchBonus) {
            return Rank.RANK_TWO;
        }
        if (count == 5 ) {
            return Rank.RANK_THREE;
        }

        Optional<Rank> result = Arrays.stream(ranks)
                .filter(c -> c.getCount() == count)
                .findFirst();

        return result.get();
    }
}
