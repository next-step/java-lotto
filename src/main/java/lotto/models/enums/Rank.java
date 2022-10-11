package lotto.models.enums;

import lotto.models.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    OTHER(0,  0);

    private final int equalCount;
    private final long amount;

    Rank(int equalCount, long amount) {
        this.equalCount = equalCount;
        this.amount = amount;
    }

    public int getEqualCount() {
        return equalCount;
    }

    public long getAmount() {
        return amount;
    }

    public static Rank findRank(List<Integer> winningLottoNumber, List<Integer> targetLottoNumber) {
        winningLottoNumber.retainAll(targetLottoNumber);
        return Rank.of(winningLottoNumber.size());
    }

    public static Rank of(int equalCount) {
        Optional<Rank> optionalRank = Arrays.stream(Rank.values())
                .filter(rank -> rank.equalCount == equalCount)
                .findFirst();

        return optionalRank.orElse(OTHER);
    }
}
