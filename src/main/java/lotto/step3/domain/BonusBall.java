package lotto.step3.domain;

import java.util.Objects;

public class BonusBall {

    private final int bonusBall;

    public BonusBall(int bonusBall) {
        this.bonusBall = bonusBall;
    }

    public BonusBall(int bonusBall, Lotto winningNumbers) {
        checkBonusBall(bonusBall, winningNumbers);
        this.bonusBall = bonusBall;
    }

    public int getBonusBall() {
        return bonusBall;
    }

    private void checkBonusBall(int bonusBall, Lotto winningNumbers) {
        boolean isAllNoneMatch = winningNumbers.getNumbers().stream()
                .noneMatch(number -> number == bonusBall);
        if (isAllNoneMatch) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusBall bonusBall1 = (BonusBall) o;
        return bonusBall == bonusBall1.bonusBall;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusBall);
    }

}
