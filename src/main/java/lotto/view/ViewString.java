package lotto.view;

public enum ViewString {
    NEWLINE(System.lineSeparator()),
    SPACE(" "),
    ;

    private final String value;

    ViewString(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
