package lotto.domain;

public enum LottoType {
    MANUAL("자동"),
    AUTO("수동");

    private final String name;

    LottoType(String name) {
        this.name = name;
    }

    public boolean isManualPurchasedLotto() {
        return this == LottoType.MANUAL;
    }

    public boolean isAutomaticPurchasedLotto() {
        return this == LottoType.AUTO;
    }
}
