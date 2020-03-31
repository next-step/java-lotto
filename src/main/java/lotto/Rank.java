package lotto;

public enum Rank {
    FIRST(6);

    Rank(int i) {
    }

    public static Rank of(int i) {
        return FIRST;
    }
}
