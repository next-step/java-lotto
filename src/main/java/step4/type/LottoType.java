package step4.type;

public enum LottoType {
    AUTO("자동"),
    MANUAL("수동");

    private final String lottoType;

    LottoType(String lottoType) {
        this.lottoType = lottoType;
    }

    public String toString(LottoType type) {
        return type.lottoType;
    }
}
