package stringcaculator.domain;

public enum DELEMETER_REGEX {
    GENERAL(",|:"), CUSTOM( "//(.)\\n(.*)");
    private String value;

    DELEMETER_REGEX(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
