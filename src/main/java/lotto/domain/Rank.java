package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치 (30,000,000원)"),
    THIRD(4, 1_500_000, "4개 일치 (1,500,000원)"),
    FOURTH(3, 50_000, "3개 일치 (50,000원)"),
    FIFTH(2, 5_000, "2개 일치 (5,000원)"),
    NOT_MATCH(0, 0,"");

    private int match;
    private int price;
    private String message;

    Rank(final int match, final int price, final String message) {
        this.match = match;
        this.price = price;
        this.message = message;
    }

    public static Rank prize(int matchCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.isMatchCount(matchCount))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Integer countMatchlottos(Rank rank, List<Lotto> lottos, Lotto winningLotto) {
        return (int) lottos.stream()
                        .filter(lotto -> rank.match == lotto.match(winningLotto))
                        .count();
    }

    private boolean isMatchCount(int matchCount) {
        return this.match == matchCount;
    }

    public String getMessage() {
        return this.message;
    }

    public int getPrice() {
        return this.price;
    }
    public int getMatch() {
        return this.match;
    }
}
