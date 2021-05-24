package lotto.domain;

public enum LottoType {
    AUTO("자동"),
    MANUAL("수동");

    private final String type;

    LottoType(String type) {
        this.type = type;
    }

    public static boolean isAuto(LottoType lottoType) {
        return AUTO.equals(lottoType);
    }

    public static boolean isManual(LottoType lottoType) {
        return MANUAL.equals(lottoType);
    }
}
