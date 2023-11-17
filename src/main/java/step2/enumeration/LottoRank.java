package step2.enumeration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    ZERO(0, 0);

    private final int match;
    private final int price;


    LottoRank(int match, int price) {
        this.match = match;
        this.price = price;
    }

    public static int getPriceByMatch(int match) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.match == match)
                .map(e -> e.price)
                .findFirst()
                .orElse(ZERO.price);
    }

    public static List<Integer> getMatches() {
        return Arrays.stream(LottoRank.values())
                .map(e -> e.match)
                .collect(Collectors.toList());
    }

    public int getPrice() {
        return this.price;
    }
}
