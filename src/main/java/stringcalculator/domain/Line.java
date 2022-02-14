package stringcalculator.domain;

import java.util.Objects;

//TODO //stringNumber //Number 합치기
public class Line {

    private static final String DEFAULT_LINE = "0";
    private final String line;

    public Line(final String line) {
        this.line = filterLine(line);
    }

    private String filterLine(String userInput) {
        if (isNullOrEmpty(userInput)) {
            return DEFAULT_LINE;
        }
        return userInput;
    }

    public String getLine() {
        return line;
    }

    private boolean isNullOrEmpty(final String line) {
        return Objects.isNull(line) || line.isEmpty();
    }
}
