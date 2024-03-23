package lotto.domain;

import java.util.Objects;

public class BonusBall {
    private final int number;

    public BonusBall(int number) {
        if (Rule.isNotInRange(number)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자만 가능합니다.");
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        BonusBall bonusBall = (BonusBall) object;
        return number == bonusBall.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
