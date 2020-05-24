package lotto;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    BOOM(0, 0);

    private int matchCount;
    private int price;

    private static final Map<Integer, LottoRank> RANK;

    static {
        RANK = Collections.unmodifiableMap(
                Stream.of(LottoRank.values())
                        .collect(Collectors.toMap(LottoRank::getMatchCount, lottoRank -> lottoRank))
        );
    }

    LottoRank(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }

    public static LottoRank valueOf(int matchCount) {
        if(matchCount < FOURTH.matchCount) {
            return LottoRank.BOOM;
        }
        return RANK.get(matchCount);
    }
}
