package lotto.constant;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    OUT_OF_RANK(0, 0);

    private final int countOfMatch;
    private final int winningMoney;
    private static final Map<Integer, LottoRank> lottoRanks = new HashMap<>();
    static {
        for (LottoRank rank : LottoRank.values()) {
            lottoRanks.put(rank.getCountOfMatch(), rank);
        }
    }

    LottoRank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return this.countOfMatch;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    public static LottoRank valueOf(int countOfMatch) {
        return lottoRanks.getOrDefault(countOfMatch, LottoRank.OUT_OF_RANK);
    }

    public static List<LottoRank> valuesWithWinningRank() {
        return Arrays.stream(LottoRank.values())
                .filter(LottoRank::isWinningRank)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private static boolean isWinningRank(LottoRank rank) {
        return rank != OUT_OF_RANK;
    }
}
