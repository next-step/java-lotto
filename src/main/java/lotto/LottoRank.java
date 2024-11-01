package lotto;

import java.util.Arrays;

public enum LottoRank {

    FIRST(1, 6),
    SECOND(2, 6),
    THIRD(3, 5),
    FOURTH(4, 4),
    FIFTH(5, 3);

    private int rank;
    private int lottoMatchingCountWithBonus;

    LottoRank(int rank, int lottoMatchingCountWithBonus) {
        this.rank = rank;
        this.lottoMatchingCountWithBonus = lottoMatchingCountWithBonus;

    }

    //머니볼이 true이면서 5개면 랭크 2 아니면 랭크 3
    public static int convertMatchingCountToRank(int matchingCount, int matchingCountWithBonus) {

        if (matchingCountWithBonus == 6 && matchingCount == 5) {
            return SECOND.rank;
        }

        return getRank(matchingCountWithBonus);
    }

    private static int getRank(int matchingCount) {
        return Arrays.stream(values()).filter(i -> i.lottoMatchingCountWithBonus == matchingCount).findFirst().map(i -> i.rank).orElse(0);
    }

    public static int convertRankToMatchingCount(int rank) {
        for (LottoRank i : values()) {
            if (i.rank == rank) {
                return i.lottoMatchingCountWithBonus;
            }
        }
        return 0;
    }


}
