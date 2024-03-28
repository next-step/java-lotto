package lotto.prize;

import java.util.HashMap;
import java.util.Objects;

public class PrizeKey {

    public static final HashMap<String, PrizeKey> memo = new HashMap<>();

    private final Integer correctNumber;
    private final boolean isBonus;

    public PrizeKey(Integer correctNumber, boolean isBonus) {
        this.correctNumber = correctNumber;
        this.isBonus = isBonus;
    }

    public static PrizeKey of(Integer correctNumber, boolean isBonus) {
        return memo.computeIfAbsent(getKey(correctNumber, isBonus), key -> new PrizeKey(correctNumber, isBonus));
    }

    private static String getKey(Integer correctNumber, boolean isBonus) {
        return correctNumber + "|" + isBonus;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PrizeKey prizeKey = (PrizeKey) object;
        return isBonus == prizeKey.isBonus && Objects.equals(correctNumber, prizeKey.correctNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correctNumber, isBonus);
    }

    @Override
    public String toString() {
        return "PrizeKey{" +
                "correctNumber=" + correctNumber +
                ", isBonus=" + isBonus +
                '}';
    }
}