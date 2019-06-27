package lotto.domain;

import java.util.Objects;

public class WonNumber {

    private int number;
    private boolean isBonusNumber;

    public static WonNumber ofNormalNumber(int number) {

        return WonNumber.of(number, false);
    }

    public static WonNumber ofBonusNumber(int number) {

        return WonNumber.of(number, true);
    }

    private static WonNumber of(int number, boolean isBonusNumber) {

        WonNumber wonNumber = new WonNumber();
        wonNumber.number = number;
        wonNumber.isBonusNumber = isBonusNumber;
        return wonNumber;
    }

    public int getNumber() {

        return number;
    }

    public boolean isBonusNumber() {

        return isBonusNumber;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WonNumber wonNumber = (WonNumber) o;
        return number == wonNumber.number &&
                isBonusNumber == wonNumber.isBonusNumber;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, isBonusNumber);
    }
}
