package com.hskim.lotto.model;

import java.util.Objects;

/**
 * Created by hs kim on 2020/08/14
 */
public class CalculateResult {

    private int result;

    public CalculateResult(int result) {

        this.result = result;
    }

    public String createResultString() {

        return String.valueOf(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CalculateResult)) return false;
        CalculateResult that = (CalculateResult) o;
        return result == that.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
