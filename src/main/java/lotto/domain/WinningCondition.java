package lotto.domain;

class WinningCondition {
    private final int matchedCount;

    private WinningCondition(int matchedCount) {
        this.matchedCount = matchedCount;
    }

    static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningCondition)) return false;

        WinningCondition that = (WinningCondition) o;

        return matchedCount == that.matchedCount;
    }

    @Override
    public int hashCode() {
        return matchedCount;
    }

    static class Builder{
        private int matchedCount;

        private Builder(){}

        Builder matchedCount(int matchedCount) {
            this.matchedCount = matchedCount;
            return this;
        }

        WinningCondition build() {
            return new WinningCondition(this.matchedCount);
        }
    }
}
