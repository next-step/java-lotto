package step4.domain;

public enum LottoType {
    AUTO("auto"),
    MANUAL("manual");

    private String type;

    LottoType(String type) {
        this.type = type;
    }
}
