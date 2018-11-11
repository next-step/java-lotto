package game.lotto.model;

import java.util.Optional;

public enum MatchType {
    MATCH_3(3, 5_000),
    MATCH_4(4, 50_000),
    MATCH_5(5, 1_500_000),
    MATCH_6(6, 2_000_000_000);

    private int key;
    private int prize;
    private String message;

    MatchType(int key, int prize) {
        this.key = key;
        this.prize = prize;
        this.message = String.format("%d개 일치 (%d원)", key, prize);
    }

    public static Optional<MatchType> valueOf(int key) {

        for (MatchType matchType : values()) {
            if(matchType.isSameKey(key)) {
                return Optional.of(matchType);
            }
        }

        return Optional.empty();
    }

    public String getMessage() {
        return this.message;
    }

    public int getPrize() {
        return this.prize;
    }

    public int getTotalPrize(int matchCount) {
        return this.prize * matchCount;
    }

    public boolean isSameKey(int key) {
        return this.key == key;
    }
}
