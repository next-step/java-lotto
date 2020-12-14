package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum DefaultDelimiters {

    COMMA(",")
    , COLON(":");

    private final String delimiter;

    DefaultDelimiters(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    /**
     * 기본 구분자들을 리스트로 반환합니다.
     * @return
     */
    public static List<String> getDefaultDelimiters() {
        return Stream.of(DefaultDelimiters.values())
                .map(DefaultDelimiters::getDelimiter)
                .collect(Collectors.toList());
    }
}
