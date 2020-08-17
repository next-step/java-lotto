package com.hskim.lotto.model;

import java.util.Objects;

public class WinningCondition {

    private int matchingNumbers;

    public WinningCondition(int matchingNumbers) {
        this.matchingNumbers = matchingNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningCondition)) return false;
        WinningCondition that = (WinningCondition) o;
        return matchingNumbers == that.matchingNumbers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchingNumbers);
    }
}
