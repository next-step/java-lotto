package lotto.domain;

public enum WinningType {
    FIRST, SECOND;

    public static WinningType findType(int countOfMatch) {
        return SECOND;
    }
}
