package study.calculator;

import java.util.Arrays;
import java.util.List;

public class Delimiter {

    private final String value;

    public Delimiter(String value) {
        if (value.length() < 1) {
            throw new IllegalArgumentException("구분자는 빈 문자열일 수 없습니다.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public List<String> split(String source) {
        return Arrays.asList(source.split(value));
    }

}
