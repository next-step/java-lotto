package com.hskim.lotto.calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hs kim on 2020/08/14
 */
public class UserInputTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        UserInput userInput = new UserInput("test");

        // when & then
        assertThat(userInput).isEqualTo(new UserInput("test"));
    }

    @DisplayName("getNumberTokens() 테스트")
    @ParameterizedTest
    @MethodSource("provideInputs")
    void getNumberToken(String input, List<String> tokens) {
        // given
        UserInput userInput = new UserInput(input);
        CalculatorNumberTokens expected = new CalculatorNumberTokens(tokens);

        // when
        CalculatorNumberTokens calculatorNumberTokens = userInput.getNumberTokens();

        // then
        assertThat(calculatorNumberTokens).isEqualTo(expected);
    }

    private static Stream<Arguments> provideInputs() {

        return Stream.of(
                /*
                    null or blank
                 */
                Arguments.of(null, Collections.singletonList("0")),
                Arguments.of("", Collections.singletonList("0")),
                Arguments.of(" ", Collections.singletonList("0")),
                /*
                    input with custom delimiter
                 */
                Arguments.of("//#\\n3#5#7#9", Arrays.asList("3", "5", "7", "9")),
                Arguments.of("//;\\n1;2;3", Arrays.asList("1", "2", "3")),
                Arguments.of("//@\\n2@4@6@8", Arrays.asList("2", "4", "6", "8")),
                /*
                    input with normal delimiter
                 */
                Arguments.of("3,5,7,9", Arrays.asList("3", "5", "7", "9")),
                Arguments.of("1:2:3", Arrays.asList("1", "2", "3")),
                Arguments.of("2,4:6,8", Arrays.asList("2", "4", "6", "8")),
                Arguments.of("1", Collections.singletonList("1"))
        );
    }
}
