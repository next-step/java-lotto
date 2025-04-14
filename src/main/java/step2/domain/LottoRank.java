package step2.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoRank {
    MATCH_3(3, 5_000, "3개 일치 (5000원)"),
    MATCH_4(4, 50_000, "4개 일치 (50000원)"),
    MATCH_5(5, 1_500_000, "5개 일치 (1500000원)"),
    MATCH_6(6, 2_000_000_000, "6개 일치 (2000000000원)"),
    NO_MATCH(0, 0, "NO_MATCH");

    private static final Map<Integer, LottoRank> MATCH_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(rank -> rank.match, Function.identity()));

    private final int match;
    private final int money;
    private final String description;

    LottoRank(int match, int money, String description) {
        this.match = match;
        this.money = money;
        this.description = description;
    }

    public static LottoRank fromMatch(int match) {
        return MATCH_MAP.getOrDefault(match, NO_MATCH);
    }

    public int money() {
        return money;
    }

    public String description() {
        return description;
    }
}
