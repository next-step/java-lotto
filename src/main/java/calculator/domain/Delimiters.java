package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Delimiters {

    private static final String TO_STRING_DELIMITER = "|";

    private final List<String> delimiters;

    public Delimiters() {
        this(DefaultDelimiters.getDefaultDelimiters());
    }

    public Delimiters(List<String> delimiters) {
        this.delimiters = delimiters;
    }

    /**
     * 적합한 구분자인 경우 구분자목록에 추가합니다.
     * @param delimiter
     */
    public void addDelimiter(String delimiter) {
        if(this.isNotDelimiter(delimiter)) {
            return;
        }
        this.delimiters.add(delimiter);
    }

    /**
     * 적합하지 않은 구분자인지 확인합니다.
     * @param delimiter
     * @return
     */
    private boolean isNotDelimiter(String delimiter) {
        return delimiter == null || delimiter.length() == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delimiters that = (Delimiters) o;
        return Objects.equals(delimiters, that.delimiters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiters);
    }

    @Override
    public String toString() {
        return String.join(Delimiters.TO_STRING_DELIMITER, this.delimiters);
    }
}
