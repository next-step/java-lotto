package lotto.domain;

public enum LottoType {
    AUTOMATIC, MANUAL;

    public boolean isAutomatic() {
        return this == LottoType.AUTOMATIC;
    }

    public boolean isManual() {
        return this == LottoType.MANUAL;
    }
}
