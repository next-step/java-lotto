package com.kkambi.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FormulaTest {

    private static final Pattern GROUP_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String BASIC_DELIMITER = "[,:]";

    @DisplayName("빈 문자열이나 null을 입력받으면 0을 저장한다")
    @MethodSource("getInvalidFormula")
    @ParameterizedTest
    void createNumbersWithNumberList(String formulaString) {
        // when
        Formula formula = new Formula(formulaString);
        List<Element> elements = formula.split(GROUP_PATTERN, BASIC_DELIMITER)
                .getElements();

        // then
        assertThat(elements).containsExactly(new Element("0"));
    }

    static Stream<Arguments> getInvalidFormula() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of("")
        );
    }

    @DisplayName("그룹 패턴과 기본 구분자에 맞게 계산식을 숫자로 변환한다")
    @MethodSource("getFormula")
    @ParameterizedTest
    void createNumbersWithNumberList(String formulaString, List<Element> expected) {
        // when
        Formula formula = new Formula(formulaString);
        List<Element> elements = formula.split(GROUP_PATTERN, BASIC_DELIMITER)
                .getElements();

        // then
        assertThat(elements).containsExactlyElementsOf(expected);
    }

    static Stream<Arguments> getFormula() {
        return Stream.of(
                Arguments.of(
                        "//!\n1!2!3",
                        Arrays.asList(new Element("1"), new Element("2"), new Element("3"))
                ),
                Arguments.of(
                        "1,2:3",
                        Arrays.asList(new Element("1"), new Element("2"), new Element("3"))
                ),
                Arguments.of("1", Collections.singletonList(new Element("1")))
        );
    }
}
