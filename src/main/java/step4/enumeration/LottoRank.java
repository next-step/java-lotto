package step4.enumeration;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum LottoRank {

    FIRST(6, 2_000_000_000, "6개 일치 (2000000000원) - %s개"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30000000원) - %s개"),
    THIRD(5, 1_500_000, "5개 일치 (1500000원) - %s개"),
    FOURTH(4, 50_000, "4개 일치 (50000원) - %s개"),
    FIFTH(3, 5_000, "3개 일치 (5000원) - %s개"),
    ZERO(0, 0, "");

    private final int match;
    private final int price;
    private final String message;


    LottoRank(int match, int price, String message) {
        this.match = match;
        this.price = price;
        this.message = message;
    }

    private static final List<LottoRank> ALL_LOTTO_RANK = Arrays.stream(LottoRank.values()).collect(Collectors.toList());
    private static final List<LottoRank> ALL_NORMAL_LOTTO_RANK = Arrays.stream(LottoRank.values())
            .filter(rank -> rank != SECOND && rank != ZERO)
            .collect(Collectors.toList());

    public static int getPriceByName(LottoRank name) {
        return ALL_LOTTO_RANK.stream()
                .filter(lottoRank -> lottoRank.equals(name))
                .map(e -> e.price)
                .findFirst()
                .orElse(ZERO.price);
    }

    public int getPrice() {
        return this.price;
    }

    public int getMatch() {
        return this.match;
    }

    public String getMessage() {
        return this.message;
    }

    public static LottoRank getRank(int match) {
        return ALL_NORMAL_LOTTO_RANK.stream()
                .filter(lottoRank -> lottoRank.match == match)
                .findFirst()
                .orElse(ZERO);
    }

    public static Map<LottoRank, Integer> rankMap() {
        Map<LottoRank, Integer> winnerBoard = new EnumMap<>(LottoRank.class);
        ALL_LOTTO_RANK.forEach(rank -> winnerBoard.put(rank, 0));
        return winnerBoard;
    }
}
