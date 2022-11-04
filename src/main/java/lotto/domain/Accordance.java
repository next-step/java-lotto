package lotto.domain;

import java.util.Objects;

public class Accordance {

    private final long countSameNumbers;
    private final boolean containsBonusNumber;

    public Accordance(long countSameNumbers, boolean containsBonusNumber) {
        this.countSameNumbers = countSameNumbers;
        this.containsBonusNumber = containsBonusNumber;
    }

    public long getCountSameNumbers() {
        return countSameNumbers;
    }

    public boolean containsBonusNumber() {
        return containsBonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Accordance that = (Accordance) o;
        return countSameNumbers == that.countSameNumbers && containsBonusNumber == that.containsBonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countSameNumbers, containsBonusNumber);
    }
}
