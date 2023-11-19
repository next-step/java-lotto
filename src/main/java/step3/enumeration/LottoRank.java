package step3.enumeration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    ZERO(0, 0);

    private final int match;
    private final int price;


    LottoRank(int match, int price) {
        this.match = match;
        this.price = price;
    }

    public static final List<LottoRank> ALL_LOTTO_RANK = Arrays.asList(LottoRank.values());
    public static final List<LottoRank> ALL_BONUS_RANK = List.of(LottoRank.SECOND);
    public static final List<LottoRank> ALL_NORMAL_LOTTO_RANK = Arrays.stream(LottoRank.values())
            .filter(rank -> rank != SECOND && rank != ZERO)
            .collect(Collectors.toList());

    public static int getPriceByMatch(int match) {
        return ALL_NORMAL_LOTTO_RANK.stream()
                .filter(lottoRank -> lottoRank.match == match)
                .map(e -> e.price)
                .findFirst()
                .orElse(ZERO.price);
    }

    public static int getBonusPriceByMatch(int match) {
        return ALL_BONUS_RANK.stream()
                .filter(lottoRank -> lottoRank.match == match)
                .map(e -> e.price)
                .findFirst()
                .orElse(ZERO.price);
    }

    public static List<Integer> getMatches() {
        return ALL_NORMAL_LOTTO_RANK.stream()
                .map(e -> e.match)
                .collect(Collectors.toList());
    }

    public static List<Integer> getBonusMatches() {
        return ALL_BONUS_RANK.stream()
                .map(e -> e.match)
                .collect(Collectors.toList());
    }

    public int getPrice() {
        return this.price;
    }

    public int getMatch() {
        return this.match;
    }
}
