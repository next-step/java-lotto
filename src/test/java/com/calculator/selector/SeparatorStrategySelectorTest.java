package com.calculator.selector;

import com.calculator.domain.BaseSeparator;
import com.calculator.domain.CustomSeparator;
import com.calculator.domain.SeparatorStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeparatorStrategySelectorTest {

    @DisplayName("입력 값에 따라 의도에 맞는 문자열 분리 구현체를 반환하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideDummyString")
    void selectSeparatorStrategyTest(final String dummyString, final String expectedClassName) {
        SeparatorStrategySelector separatorStrategySelector = new SeparatorStrategySelector(dummyString);
        SeparatorStrategy result = separatorStrategySelector.selectSeparatorStrategy();

        assertEquals(result.getClass().getName(), expectedClassName);
    }

    private static Stream<Arguments> provideDummyString() {
        return Stream.of(
                Arguments.of("1:2,3", BaseSeparator.class.getName()),
                Arguments.of("//&\n4&5", CustomSeparator.class.getName()),
                Arguments.of("//#\n2#7", CustomSeparator.class.getName())
        );
    }
}
