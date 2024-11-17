package lotto.settings;

public enum LottoSettings {
    MIN(1),
    MAX(45),
    SIZE(6),
    DEFAULT_PRICE(1_000);

    private final int value;

    LottoSettings(int value) {
        this.value = value;
    }

    public static boolean isValidSize(int value) {
        return SIZE.value == value;
    }

    public static boolean isNumberInValidRange(int value) {
        return MIN.value <= value && value <= MAX.value;
    }

    public int value() {
        return value;
    }
}
