package step03.domain;

import java.util.Objects;

public class BonusLottoBall {

    private final LottoBall bonusBall;

    private BonusLottoBall(LottoBall bonusBall) {
        this.bonusBall = bonusBall;
    }

    public static BonusLottoBall of(LottoBall bonusBall) {
        return new BonusLottoBall(bonusBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusLottoBall that = (BonusLottoBall) o;
        return Objects.equals(bonusBall, that.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusBall);
    }
}
