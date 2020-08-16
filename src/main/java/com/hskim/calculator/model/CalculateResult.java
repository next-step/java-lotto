package com.hskim.calculator.model;

import java.util.Objects;

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
