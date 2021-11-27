package step1.domain;

import java.util.Objects;

public class Delimiter {
    public static final String START_DELIMITER = "//";
    public static final String END_DELIMITER = "\\n";

    private final String delimiter;

    public Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    private void validateDelimiter(String s) {
        throw new RuntimeException("구분자 입력 오류");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delimiter delimeter1 = (Delimiter) o;
        return Objects.equals(delimiter, delimeter1.delimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiter);
    }
}
