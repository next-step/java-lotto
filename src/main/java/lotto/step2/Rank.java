package lotto.step2;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0, "일치하는 번호 없음"),
    FOURTH(3, 5_000, "3개 번호 일치"),
    THIRD(4, 50_000, "4개 번호 일치"),
    SECOND(5, 1_500_000, "5개 번호 일치"),
    FIRST(6, 2_000_000_000, "6개 번호 일치");
    
    private final int hit;
    private final int amount;

    Rank(int hit, int amount, String message) {
        this.hit = hit;
        this.amount = amount;
    }

    public int amount() {
        return this.amount;
    }

    public int hit() {
        return this.hit;
    }

    public static Rank from(int hit) {
        return Arrays.stream(values())
                .filter(rank -> rank.hit == hit)
                .findFirst()
                .orElse(MISS);
    }
}
