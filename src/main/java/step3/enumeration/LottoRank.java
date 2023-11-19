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

    public static final List<LottoRank> ALL_LOTTO_RANK = Arrays.stream(LottoRank.values()).collect(Collectors.toList());
    public static final List<LottoRank> ALL_NORMAL_LOTTO_RANK = Arrays.stream(LottoRank.values())
            .filter(rank -> rank != SECOND && rank != ZERO)
            .collect(Collectors.toList());

    public static int getPriceByName(String name) {
        return ALL_LOTTO_RANK.stream()
                .filter(lottoRank -> lottoRank.name().equals(name))
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

    public static String getName(int match) {
        return ALL_NORMAL_LOTTO_RANK.stream()
                .filter(lottoRank -> lottoRank.match == match)
                .map(Enum::name)
                .findFirst()
                .orElse(ZERO.name());
    }
}
