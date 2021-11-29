package com.kkambi.calculator;

import com.kkambi.calculator.domain.Element;
import com.kkambi.calculator.domain.Elements;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @DisplayName("문자열로 된 계산식을 원소들로 나눈다")
    @MethodSource("getFormulaString")
    @ParameterizedTest
    void split(String formulaString, List<Element> expected) {
        // when
        // then
        Elements elements = StringAddCalculator.split(formulaString);
        assertThat(elements.getElements()).containsExactlyElementsOf(expected);
    }

    static Stream<Arguments> getFormulaString() {
        return Stream.of(
                Arguments.of(null, Collections.singletonList(new Element("0"))),
                Arguments.of("", Collections.singletonList(new Element("0"))),
                Arguments.of("10", Collections.singletonList(new Element("10"))),
                Arguments.of("1,2", Arrays.asList(new Element("1"), new Element("2"))),
                Arguments.of("1,2:3", Arrays.asList(new Element("1"), new Element("2"), new Element("3"))),
                Arguments.of("//;\n1;2;3", Arrays.asList(new Element("1"), new Element("2"), new Element("3")))
        );
    }

    @DisplayName("문자열로 된 계산식의 합을 반환한다")
    @ValueSource(strings = {"6", "2,4", "1,2:3", "//;\n1;2;3"})
    @ParameterizedTest
    void sum(String formulaString) {
        // given
        Elements elements = StringAddCalculator.split(formulaString);

        // when
        // then
        assertThat(StringAddCalculator.sum(elements)).isEqualTo(6);
    }


    @DisplayName("숫자가 아닌 값이나, 음수를 넣으면 예외를 반환한다")
    @ValueSource(strings = {"-1,2,3", "+,2,3"})
    @ParameterizedTest
    void sumThrowingException(String formulaString) {
        // given
        Elements elements = StringAddCalculator.split(formulaString);

        // when
        // then
        assertThatThrownBy(() -> StringAddCalculator.sum(elements))
                .isInstanceOf(RuntimeException.class);
    }
}
