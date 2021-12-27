package stringcaculator.domain;

public enum DelimiterRegex {
    GENERAL(",|:"), CUSTOM( "//(.)\\n(.*)");
    private String value;

    DelimiterRegex(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}