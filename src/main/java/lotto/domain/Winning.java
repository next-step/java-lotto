package lotto.domain;

import java.util.Objects;

public class WinNumber {
    private int number;
    public WinNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinNumber)) return false;
        WinNumber winNumber = (WinNumber) o;
        return number == winNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
