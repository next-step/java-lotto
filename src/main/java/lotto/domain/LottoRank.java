package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public enum LottoRank implements Rank {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    private final int count;
    private final int price;


    LottoRank(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public static Rank match(final int count) {
        Optional<LottoRank> rank = Arrays.stream(values()).filter(v -> v.count == count).findFirst();
        if(rank.isPresent()) return rank.get();
        return None.NONE;
    }

    @Override
    public int price(){
        return this.price;
    }

    public int count(){
        return this.count;
    }

    public enum None implements Rank {
        NONE;

        @Override
        public int price() {
            return 0;
        }
    }
}
