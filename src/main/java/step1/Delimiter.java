package step1;

import java.util.Objects;

public class Delimiter {
    private final String delimiter;

    public Delimiter(String s) {
        this.delimiter = s;
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
