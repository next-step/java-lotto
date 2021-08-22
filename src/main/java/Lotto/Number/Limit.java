package Lotto.Number;

public enum Limit {
    MAX(Constants.MAX),
    MIN(Constants.MIN);
    private int limit;

    Limit(int number) {
        this.limit = number;
    }

    public int getValue() {
        return limit;
    }

    public boolean isUnder(int lottoNumber) {
        return limit < lottoNumber;
    }

    public boolean isAbove(int lottoNumber) {
        return limit > lottoNumber;
    }

    private static class Constants {
        public static final int MAX = 45;
        public static final int MIN = 1;
    }
}