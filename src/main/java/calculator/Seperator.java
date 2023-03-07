package calculator;

public class Seperator {

    private static final String DEFAULT_SEPERATOR = ",|;";
    private final String seperator;

    private final String value;

    public Seperator(String origin) {
        validate(origin);
        this.seperator = this.parseSeperator(origin);
        this.value = this.parseOperands(origin);
    }

    public String getSeperator() {
        return this.seperator;
    }

    public String getValue() {
        return this.value;
    }


    private void validate(String origin) {
        if (origin == null || origin.isBlank()) {
            throw new RuntimeException("문자열이 빈 값 또는 공백입니다.");
        }
    }

    private String parseSeperator(String origin) {
        if (origin.equals(origin.split(DEFAULT_SEPERATOR)[0])) {
            return origin.split("//")[1].split("|n")[0];
        }
        return DEFAULT_SEPERATOR;
    }

    private String parseOperands(String origin) {
        if (DEFAULT_SEPERATOR.equals(this.seperator)) {
            return origin;
        }
        return origin.substring(origin.indexOf("\\n") + 1);
    }
}
