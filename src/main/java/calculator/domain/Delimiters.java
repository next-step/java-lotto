package calculator.domain;

import calculator.StringAddCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiters {

    private static final String TO_STRING_DELIMITER = "|";
    private static final String REGEX_HAS_CUSTOM_DELIMITER = "//(.)\n(.*)";

    private final List<String> delimiters;

    public Delimiters() {
        this(DefaultDelimiters.getDefaultDelimiters());
    }

    public Delimiters(List<String> delimiters) {
        this.delimiters = delimiters;
    }


    /**
     * 커스텀구분자가 있으면 추출하여 구분자에 추가한 후 나머지 수식을 반환합니다.
     * @param expression
     * @return
     */
    public String extractCustomDelimiter(String expression) {
        Matcher m = Pattern.compile(Delimiters.REGEX_HAS_CUSTOM_DELIMITER).matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            this.addDelimiter(m.group(1));
            return m.group(2);
        }
        return expression;
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
