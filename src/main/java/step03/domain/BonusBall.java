package step03.domain;

import java.util.Objects;

public class BonusBall {

    private final LottoBall bonusBall;

    private BonusBall(LottoBall bonusBall) {
        this.bonusBall = bonusBall;
    }

    public static BonusBall of(LottoBall bonusBall) {
        return new BonusBall(bonusBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusBall that = (BonusBall) o;
        return Objects.equals(bonusBall, that.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusBall);
    }
}
