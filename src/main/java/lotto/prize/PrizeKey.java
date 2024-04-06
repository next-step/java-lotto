package lotto.prize;

import java.util.Objects;

public class PrizeKey {

    private final long correctNumber;
    private final boolean isBonus;

    public PrizeKey(long correctNumber, boolean isBonus) {
        this.correctNumber = correctNumber;
        this.isBonus = isBonus;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
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